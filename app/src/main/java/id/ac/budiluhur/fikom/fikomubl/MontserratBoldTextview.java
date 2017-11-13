package id.ac.budiluhur.fikom.fikomubl;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Joko Priyono on 23/10/2016.
 */

public class MontserratBoldTextview extends TextView {

    public MontserratBoldTextview(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public MontserratBoldTextview(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public MontserratBoldTextview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("fonts/Montserrat-Bold.otf", context);
        setTypeface(customFont);
    }
}
