package solsoft.radajuego.Núcleo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import solsoft.radajuego.Interfaz.Pantalla;

public class MiSurface extends SurfaceView implements SurfaceHolder.Callback {


    private SurfaceHolder mSurfaceHolder;
    private Context mContext;
    private Hilo mHilo;
    private boolean mHiloFuncionando = false;
    private Pantalla mPantallaActual;
    private int mAnchoPantalla;
    private int mAltoPantalla;


    public MiSurface(Context context) {
        super(context);
        this.mSurfaceHolder = getHolder();
        this.mSurfaceHolder.addCallback(this);
        this.mContext = context;
        mHilo = new Hilo();
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mHilo.setFuncionando(true);
        mHilo.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        mAnchoPantalla = width;
        mAltoPantalla = height;
        mPantallaActual = new Pantalla(mContext, mAnchoPantalla, mAltoPantalla);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mHilo.setFuncionando(false);
        try {
            mHilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    class Hilo extends Thread {
        long tiempoDormido = 0;
        final int FPS = 60;
        final int TPS = 1000000000;

        @Override
        public void run() {
            final int FRAGMENTO_TEMPORAL = TPS / FPS;
            long tiempoReferencia = System.nanoTime();

            while (mHiloFuncionando) {
                Canvas canvas = null;
                try {
                    canvas = mSurfaceHolder.lockCanvas();
                    synchronized (mSurfaceHolder) {
                        mPantallaActual.actualizarEstado();
                        mPantallaActual.dibujar(canvas);
                    }
                } finally {
                    if (canvas != null) {
                        mSurfaceHolder.unlockCanvasAndPost(canvas);
                    }
                }

                tiempoReferencia += FRAGMENTO_TEMPORAL;
                tiempoDormido = tiempoReferencia - System.nanoTime();
                if (tiempoDormido > 0) {
                    try {
                        Thread.sleep(tiempoDormido / 1000000); //Convertimos a ms
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        void setFuncionando(boolean flag) {
            mHiloFuncionando = flag;
        }
    }
}
