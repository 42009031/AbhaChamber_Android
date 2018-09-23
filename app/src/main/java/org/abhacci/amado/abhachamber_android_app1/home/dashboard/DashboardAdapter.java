package org.abhacci.amado.abhachamber_android_app1.home.dashboard;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.abhacci.amado.abhachamber_android_app1.R;
import org.abhacci.amado.abhachamber_android_app1.common.GenericModel;
import org.abhacci.amado.abhachamber_android_app1.common.Helper;

import java.util.ArrayList;


public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {

    private ArrayList<GenericModel> mDataset;
    private Context context;

    public DashboardAdapter(Context context, ArrayList<GenericModel> myDataset) {
        this.mDataset = myDataset;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public DashboardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_dashboard_layout, parent, false);
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
            img = (ImageView) v.findViewById(R.id.img);
            name = (TextView) v.findViewById(R.id.name);

            name.setTypeface(Helper.getTypeFace(context), Typeface.BOLD);
        }


    }
}