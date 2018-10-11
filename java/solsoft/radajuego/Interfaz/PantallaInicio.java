package solsoft.radajuego.Interfaz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextPaint;
import android.view.MotionEvent;

import solsoft.radajuego.Modelo.IdPantalla;
import solsoft.radajuego.R;
import solsoft.radajuego.Utiles.Utiles;

public class PantallaInicio extends Pantalla {


    public PantallaInicio(Context context, int anchoPantalla, int altoPantalla) {
        super(context, anchoPantalla, altoPantalla);

        idPantalla = IdPantalla.INICIO;
        cargarPinceles();
        cargarPincelesTexto();
        cargarPosiciones();
        cargarTextos();
        cargarRectangulos();
    }

    @Override
    protected void cargarRectangulos() {
        super.cargarRectangulos();
        mRectangulos.put("boton", new RectF(mAnchoPantalla / 2 - mAnchoPantalla / 10, mAltoPantalla / 2 - mAltoPantalla / 10,
                mAnchoPantalla / 2 + mAnchoPantalla / 10, mAltoPantalla / 2 + mAltoPantalla / 10));
    }

    @Override
    protected void cargarTextos() {
        super.cargarTextos();
        mTextos.put("titulo", mContext.getString(R.string.app_name));
    }

    @Override
    protected void cargarPosiciones() {
        super.cargarPosiciones();
        mPosiciones.put("posTitulo", new PointF(mAnchoPantalla / 2 - mAnchoPantalla / 8, mAltoPantalla / 2 - mAltoPantalla / 5));
    }

    @Override
    protected void cargarPincelesTexto() {
        super.cargarPincelesTexto();
        TextPaint pincelTitulo = new TextPaint();
        pincelTitulo.setColor(Color.BLUE);
        pincelTitulo.setTextSize(Utiles.getPixels(35, mContext));
        mPincelesTexto.put("pincelTitulo", pincelTitulo);
    }

    @Override
    protected void cargarPinceles() {
        super.cargarPinceles();
        Paint pincelBoton = new Paint();
        pincelBoton.setColor(Color.BLACK);
        mPinceles.put("picenBoton", pincelBoton);
    }

    @Override
    public void actualizarEstado() {
        super.actualizarEstado();
    }

    @Override
    public void dibujar(Canvas canvas) {
        super.dibujar(canvas);
        canvas.drawColor(mContext.getResources().getColor(R.color.blanco));
        canvas.drawRect(mRectangulos.get("boton"), mPinceles.get("picenBoton"));
        canvas.drawText(mTextos.get("titulo"), mPosiciones.get("posTitulo").x, mPosiciones.get("posTitulo").y, mPincelesTexto.get("pincelTitulo"));
    }

    public IdPantalla onTouchEvent(MotionEvent event) {
        return idPantalla;
    }
}
