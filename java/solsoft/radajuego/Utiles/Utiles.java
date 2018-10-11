package solsoft.radajuego.Utiles;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class Utiles {

    public static int getPixels(float dp, Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().
                getMetrics(metrics);
        return (int) (dp * metrics.density);
    }
}
