package solsoft.radajuego.Interfaz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextPaint;

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
        mRectangulos.put("boton", new RectF(mAnchoPantalla / 2 - mAnchoPantalla / 10, mAltoPantalla / 2 - mAltoPantalla / 10,
                mAnchoPantalla / 2 + mAnchoPantalla / 10, mAltoPantalla / 2 + mAltoPantalla / 10));
    }

    private void cargarTextos() {
        mTextos =  new HashMap<>();
        mTextos.put("titulo", mContext.getString(R.string.app_name));
    }

    private void cargarPosiciones() {
        mPosiciones = new HashMap<>();
        mPosiciones.put("posTitulo", new PointF(mAnchoPantalla / 2 - mAnchoPantalla / 8, mAltoPantalla / 2 - mAltoPantalla / 5));
    }

    private void cargarPincelesTexto() {
        mPincelesTexto = new HashMap<>();
        TextPaint pincelTitulo = new TextPaint();
        pincelTitulo.setColor(Color.BLUE);
        pincelTitulo.setTextSize(mAltoPantalla / 10);
        mPincelesTexto.put("pincelTitulo", pincelTitulo);
    }

    private void cargarPinceles() {
        mPinceles = new HashMap<>();
        Paint pincelBoton = new Paint();
        pincelBoton.setColor(Color.BLACK);
        mPinceles.put("picenBoton", pincelBoton);
    }

    public void actualizarEstado() {
    }

    public void dibujar(Canvas canvas) {
        canvas.drawColor(mContext.getResources().getColor(R.color.blanco));
        canvas.drawRect(mRectangulos.get("boton"), mPinceles.get("picenBoton"));
        canvas.drawText(mTextos.get("titulo"), mPosiciones.get("posTitulo").x, mPosiciones.get("posTitulo").y, mPincelesTexto.get("pincelTitulo"));
    }
}
