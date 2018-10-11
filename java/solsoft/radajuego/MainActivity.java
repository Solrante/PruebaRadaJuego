package solsoft.radajuego;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import solsoft.radajuego.Núcleo.MiSurface;

public class MainActivity extends AppCompatActivity {

    MiSurface miSurface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        miSurface = new MiSurface(this);
        miSurface.setKeepScreenOn(true);
        setContentView(miSurface);
    }

    @Override
    protected void onPause() {
        super.onPause();
        miSurface.pausa();
    }

    @Override
    protected void onResume() {
        super.onResume();
        miSurface.continuar();
    }
}
