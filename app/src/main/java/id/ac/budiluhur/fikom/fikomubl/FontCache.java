package id.ac.budiluhur.fikom.fikomubl;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

public class FontCache {

    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(String montserrat, Context context) {
        Typeface typeface = fontCache.get(montserrat);

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), montserrat);
            } catch (Exception e) {
                return null;
            }

            fontCache.put(montserrat, typeface);
        }

        return typeface;
    }
}