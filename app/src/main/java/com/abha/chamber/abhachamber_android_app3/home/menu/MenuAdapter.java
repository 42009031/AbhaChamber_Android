package com.abha.chamber.abhachamber_android_app3.home.menu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abha.chamber.abhachamber_android_app3.common.GenericModel;
import com.abha.chamber.abhachamber_android_app3.common.Helper;

import org.abhacci.amado.abhachamber_android_app1.R;


import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private ArrayList<GenericModel> mDataset;
    private Context context;

    public MenuAdapter(Context context, ArrayList<GenericModel> myDataset) {
        this.mDataset = myDataset;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_menu_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int img = mDataset.get(position).getImage();
        String name = mDataset.get(position).getName();

        holder.img.setImageResource(img);
        holder.name.setText(name);

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;

        private ViewHolder(View v) {
            super(v);
            img = (ImageView) v.findViewById(R.id.nav_imgView);
            name = (TextView) v.findViewById(R.id.nav_title_textView);

            name.setTypeface(Helper.getTypeFace(context));
        }
    }
}
