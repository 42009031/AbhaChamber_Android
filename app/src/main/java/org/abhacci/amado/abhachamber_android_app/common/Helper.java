package org.abhacci.amado.abhachamber_android_app.common;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;

import org.abhacci.amado.abhachamber_android_app.R;

import java.util.Locale;

public class Helper {

    public static Typeface getTypeFace(Context context){
        Typeface lightFace;
        String language = Locale.getDefault().getDisplayLanguage();
        if (language.contains("العربية")) {
            lightFace = Typeface.createFromAsset(context.getAssets(), "fonts/arabic_font.ttf");
        } else {
            lightFace = Typeface.createFromAsset(context.getAssets(), "fonts/comic.ttf");
        }
        return lightFace;
    }


    public static void setSrc4BackImg(ImageView view) {
        String language = Locale.getDefault().getDisplayLanguage();
        if (language.contains("العربية")) {
            view.setImageResource(R.drawable.ic_back);
        } else {
            view.setImageResource(R.drawable.ic_forward);
        }
    }
}
