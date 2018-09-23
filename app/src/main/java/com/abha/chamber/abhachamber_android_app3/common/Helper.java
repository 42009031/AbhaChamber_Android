package com.abha.chamber.abhachamber_android_app3.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.widget.ImageView;

import org.abhacci.amado.abhachamber_android_app1.R;

public class Helper {



    public static Typeface getTypeFace(Context context){
        Typeface lightFace;
        SharedPreferences prefs = context.getSharedPreferences("APP_DATA", Context.MODE_PRIVATE);
        if (prefs.getString("LANG", "").equals("ar")) {
            lightFace = Typeface.createFromAsset(context.getAssets(), "fonts/arabic_font.ttf");
        } else {
            lightFace = Typeface.createFromAsset(context.getAssets(), "fonts/comic.ttf");
        }
        return lightFace;
    }


    public static void setSrc4BackImg(ImageView view) {
        SharedPreferences prefs = view.getContext().getSharedPreferences("APP_DATA", Context.MODE_PRIVATE);
        if (prefs.getString("LANG", "").equals("ar")) {
            view.setImageResource(R.drawable.ic_back);
        } else {
            view.setImageResource(R.drawable.ic_forward);
        }
    }
}
