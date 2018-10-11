package solsoft.radajuego.Interfaz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.Log;
import android.view.MotionEvent;

import java.util.HashMap;
import java.util.Map;

import solsoft.radajuego.R;

public class Pantalla {

    private Context mContext;
    private int mAnchoPantalla;
    private int mAltoPantalla;

    private Map<String, Paint> mPinceles;
    private Map<String, TextPaint> mPincelesTexto;
    private Map<String, PointF> mPosiciones;
    private Map<String, RectF> mRectangulos;
    private Map<String, String> mTextos;

    public Pantalla(Context context, int anchoPantalla, int altoPantalla) {
        mContext = context;
        mAnchoPantalla = anchoPantalla;
        mAltoPantalla = altoPantalla;

        cargarPinceles();
        cargarPincelesTexto();
        cargarPosiciones();
        cargarTextos();
        cargarRectangulos();
    }

    private void cargarRectangulos() {
        mRectangulos = new HashMap<>();
    }

    private void cargarTextos() {
        mTextos = new HashMap<>();
    }

    private void cargarPosiciones() {
        mPosiciones = new HashMap<>();
    }

    private void cargarPincelesTexto() {
        mPincelesTexto = new HashMap<>();
    }

    private void cargarPinceles() {
        mPinceles = new HashMap<>();
    }

    public void actualizarEstado() {
    }

    public void dibujar(Canvas canvas) {
    }


    public int onTouchEvent(MotionEvent event) {
        return 0;
    }
}
