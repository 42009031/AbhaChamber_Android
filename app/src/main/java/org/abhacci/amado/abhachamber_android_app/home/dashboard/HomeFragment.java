package org.abhacci.amado.abhachamber_android_app.home.dashboard;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rd.PageIndicatorView;

import org.abhacci.amado.abhachamber_android_app.R;
import org.abhacci.amado.abhachamber_android_app.common.GenericModel;
import org.abhacci.amado.abhachamber_android_app.common.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

   

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_layout, container, false);

        initSliderImageView(rootView);
        initRecycelrView(rootView);
        
        return  rootView;
    }

    private void initRecycelrView(View rootView ) {

        final ArrayList<GenericModel> dashboardModelList = new ArrayList<>();
        dashboardModelList.add(new GenericModel(R.drawable.internet, "الخدمات الالكترونية."));
        dashboardModelList.add(new GenericModel(R.drawable.departments, "إدارات الغرفة."));
        dashboardModelList.add(new GenericModel(R.drawable.localization_trianing, "التوطين والتدريب."));
        dashboardModelList.add(new GenericModel(R.drawable.connections, "اللجان النوعية."));
        dashboardModelList.add(new GenericModel(R.drawable.projects, "المنشآت الصغيرة والمتوسطة."));
        dashboardModelList.add(new GenericModel(R.drawable.business_women, "سيدات الاعمال."));
        dashboardModelList.add(new GenericModel(R.drawable.research, "البحوث والمعلومات."));
        dashboardModelList.add(new GenericModel(R.drawable.relation, "الإعلام والعلاقات العامة."));
        dashboardModelList.add(new GenericModel(R.drawable.about, "عن الغرفة."));
        dashboardModelList.add(new GenericModel(R.drawable.call, "إتصل بنا."));

        LinearLayoutManager layoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.HORIZONTAL, false);
        RecyclerView dashboard_rv = (RecyclerView) rootView.findViewById(R.id.dashboard_rv);
        dashboard_rv.setLayoutManager(layoutManager);
        DashboardAdapter adapter = new DashboardAdapter(getActivity(), dashboardModelList);
        dashboard_rv.setAdapter(adapter);
        dashboard_rv.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), dashboard_rv, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(getActivity(), dashboardModelList.get(position).getName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );

    }
    private void initSliderImageView(View rootView) {

        final int[] currentPage = {0};
        int NUM_PAGES = 0;
        final Integer[] IMAGES = {R.drawable.slider2,
                R.drawable.slider3,
                R.drawable.six,
                R.drawable.eight};

        ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
        ImagesArray.addAll(Arrays.asList(IMAGES));

        final ViewPager mPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        PageIndicatorView pageIndicatorView = (PageIndicatorView) rootView.findViewById(R.id.pageIndicatorView);

        mPager.setAdapter(new SlidingImageAdapter(getActivity(), ImagesArray));

        NUM_PAGES = IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();

        final int finalNUM_PAGES = NUM_PAGES;
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage[0] == finalNUM_PAGES) {
                    currentPage[0] = 0;
                }
                mPager.setCurrentItem(currentPage[0]++, true);
            }
        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);
    }
}
