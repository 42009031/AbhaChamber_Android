package com.abha.chamber.abhachamber_android_app3.introduction;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.abha.chamber.abhachamber_android_app3.common.Helper;
import com.abha.chamber.abhachamber_android_app3.home.HomeActivity;

import org.abhacci.amado.abhachamber_android_app1.R;

import java.util.ArrayList;

public class _IntroductionActivity extends FragmentActivity {

    private ImageView circle1, circle2, circle3;
    private Animation rotate1, rotate2, rotate3;
    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        Button nextBtn = (Button) findViewById(R.id.nextBtn);
        pager = (ViewPager) findViewById(R.id.viewPager);
        
        circle1 = (ImageView) findViewById(R.id.circle1);
        circle2 = (ImageView) findViewById(R.id.circle2);
        circle3 = (ImageView) findViewById(R.id.circle3);

        rotate1 = AnimationUtils.loadAnimation(this, R.anim.rotate);
        rotate2 = AnimationUtils.loadAnimation(this, R.anim.rotate2);
        rotate3 = AnimationUtils.loadAnimation(this, R.anim.rotate3);

        circle1.startAnimation(rotate1);
        circle2.startAnimation(rotate2);
        circle3.startAnimation(rotate3);

        ArrayList<IntroModel> introModelsArray = new ArrayList<>();
        introModelsArray.add(new IntroModel("أهلا وسهلاً بك", "تقدم الغرفة التجارية والصناعية في أبها تطبيقها لخدمة المستفيدين ومواكبة التقنية"));
        introModelsArray.add(new IntroModel("جديد الغرفة", "تابع أحدث أخبار الغرفة والمناقصات والتعاميم وأحدث الفرص الوظيفية ! كم يمكنك أيضا متابعة الدورات التدريبية وغيرها"));
        introModelsArray.add(new IntroModel("فروعنا", "بإمكانك الآن مشاهدة جميع فروعنا والوصول اليها عبر التطبيق كما بإمكانك التواصل معنا على أي من الأرقام المذكورة"));
        pager.setAdapter(new MyPagerAdapter(this, introModelsArray));
        pager.setOffscreenPageLimit(3);

        nextBtn.setTypeface(Helper.getTypeFace(this));

    }

    public void onNextClick(View view) {
        startActivity(new Intent(_IntroductionActivity.this, HomeActivity.class));
        finish();
    }

    private class MyPagerAdapter extends PagerAdapter {

        private ArrayList<IntroModel> introModelsArray;
        private LayoutInflater inflater;
        private Context context;

        public MyPagerAdapter(Context context, ArrayList<IntroModel> introModelsArray) {
            this.context = context;
            this.introModelsArray = introModelsArray;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return introModelsArray.size();
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            View introLayout = inflater.inflate(R.layout.adapter_intro_layout, view, false);

            final TextView header = (TextView) introLayout.findViewById(R.id.header);
            final TextView content = (TextView) introLayout.findViewById(R.id.content);

            header.setTypeface(Helper.getTypeFace(_IntroductionActivity.this));
            content.setTypeface(Helper.getTypeFace(_IntroductionActivity.this));

            header.setText(introModelsArray.get(position).getHeader());
            content.setText(introModelsArray.get(position).getContent());

            view.addView(introLayout, 0);
            return introLayout;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {
        }

        @Override
        public Parcelable saveState() {
            return null;
        }

    }


}
