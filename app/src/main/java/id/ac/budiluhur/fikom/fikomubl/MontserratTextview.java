package id.ac.budiluhur.fikom.fikomubl;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Joko Priyono on 23/10/2016.
 */

public class MontserratTextview extends TextView {

    public MontserratTextview(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public MontserratTextview(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public MontserratTextview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("fonts/Montserrat-Regular.otf", context);
        setTypeface(customFont);
    }
}
