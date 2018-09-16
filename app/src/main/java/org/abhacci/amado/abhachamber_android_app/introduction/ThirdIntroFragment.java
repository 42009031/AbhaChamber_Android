package org.abhacci.amado.abhachamber_android_app.introduction;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.abhacci.amado.abhachamber_android_app.R;

/**
 * Created by Amado on 01-Sep-18.
 */

public class ThirdIntroFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_intro_fragment, container, false);
        return view;
    }

    public static ThirdIntroFragment newInstance(String text) {

        ThirdIntroFragment f = new ThirdIntroFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }
}
