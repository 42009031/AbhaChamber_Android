package org.abhacci.amado.abhachamber_android_app.introduction;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.abhacci.amado.abhachamber_android_app.R;
import org.abhacci.amado.abhachamber_android_app.common.Helper;

/**
 * Created by Amado on 01-Sep-18.
 */

public class ThirdIntroFragment extends Fragment {

    private TextView header, content;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_intro_fragment, container, false);

        header = (TextView) view.findViewById(R.id.header);
        content = (TextView) view.findViewById(R.id.content);

        header.setTypeface(Helper.getTypeFace(getActivity()));
        content.setTypeface(Helper.getTypeFace(getActivity()));

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
