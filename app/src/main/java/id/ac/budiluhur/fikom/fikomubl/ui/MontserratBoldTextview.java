package id.ac.budiluhur.fikom.fikomubl.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import id.ac.budiluhur.fikom.fikomubl.FontCache;

public class MontserratBoldTextview extends android.support.v7.widget.AppCompatTextView {

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
