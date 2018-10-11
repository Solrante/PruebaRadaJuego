package solsoft.radajuego.Interfaz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextPaint;
import android.view.MotionEvent;

import java.util.HashMap;
import java.util.Map;

import solsoft.radajuego.Modelo.IdPantalla;

public class Pantalla {

    protected Context mContext;
    protected int mAnchoPantalla;
    protected int mAltoPantalla;
    public IdPantalla idPantalla;

    protected Map<String, Paint> mPinceles;
    protected Map<String, TextPaint> mPincelesTexto;
    protected Map<String, PointF> mPosiciones;
    protected Map<String, RectF> mRectangulos;
    protected Map<String, String> mTextos;

    public Pantalla(Context context, int anchoPantalla, int altoPantalla) {
        mContext = context;
        mAnchoPantalla = anchoPantalla;
        mAltoPantalla = altoPantalla;
    }

    protected void cargarRectangulos() {
        mRectangulos = new HashMap<>();
    }

    protected void cargarTextos() {
        mTextos = new HashMap<>();
    }

    protected void cargarPosiciones() {
        mPosiciones = new HashMap<>();
    }

    protected void cargarPincelesTexto() {
        mPincelesTexto = new HashMap<>();
    }

    protected void cargarPinceles() {
        mPinceles = new HashMap<>();
    }

    public void actualizarEstado() {
    }

    public void dibujar(Canvas canvas) {
    }

    public IdPantalla onTouchEvent(MotionEvent event) {
        return idPantalla;
    }
}
