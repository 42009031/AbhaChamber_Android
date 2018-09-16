package org.abhacci.amado.abhachamber_android_app.introduction;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.abhacci.amado.abhachamber_android_app.R;

public class FirstIntroFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_intro_fragment, container, false);
        return view;
    }

    public static FirstIntroFragment newInstance(String text) {

        FirstIntroFragment f = new FirstIntroFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);
        f.setArguments(b);
        return f;
    }
}
