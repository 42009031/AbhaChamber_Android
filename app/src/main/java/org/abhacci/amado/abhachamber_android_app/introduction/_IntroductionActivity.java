package org.abhacci.amado.abhachamber_android_app.introduction;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import org.abhacci.amado.abhachamber_android_app.R;
import org.abhacci.amado.abhachamber_android_app.common.Helper;
import org.abhacci.amado.abhachamber_android_app.home.HomeActivity;

public class _IntroductionActivity extends FragmentActivity {

    private ImageView circle1, circle2, circle3;
    private Animation rotate1, rotate2, rotate3;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        Button nextBtn = (Button) findViewById(R.id.nextBtn);
        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        
        circle1 = (ImageView) findViewById(R.id.circle1);
        circle2 = (ImageView) findViewById(R.id.circle2);
        circle3 = (ImageView) findViewById(R.id.circle3);

        rotate1 = AnimationUtils.loadAnimation(this, R.anim.rotate);
        rotate2 = AnimationUtils.loadAnimation(this, R.anim.rotate2);
        rotate3 = AnimationUtils.loadAnimation(this, R.anim.rotate3);

        circle1.startAnimation(rotate1);
        circle2.startAnimation(rotate2);
        circle3.startAnimation(rotate3);
        
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        nextBtn.setTypeface(Helper.getTypeFace(this));
    }

    public void onNextClick(View view) {
        startActivity(new Intent(_IntroductionActivity.this, HomeActivity.class));
        finish();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {

                case 0: return FirstIntroFragment.newInstance("FirstFragment, Instance 1");
                case 1: return SecondIntroFragment.newInstance("SecondFragment, Instance 1");
                case 2: return ThirdIntroFragment.newInstance("ThirdFragment, Instance 1");

                default: return ThirdIntroFragment.newInstance("ThirdFragment, Default");
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        rotate1.cancel();
        rotate2.cancel();
        rotate3.cancel();
    }
}
