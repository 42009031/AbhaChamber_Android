package org.abhacci.amado.abhachamber_android_app1.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import org.abhacci.amado.abhachamber_android_app1.R;
import org.abhacci.amado.abhachamber_android_app1.introduction._IntroductionActivity;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    private ImageView mainCircle, icon1, icon2, icon3, icon4, icon5, logoName, leftExplore, rightExplore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        declareVar();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setAnimation();
    }

    private void setAnimation() {
        final Animation rightSwipe = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.right_side);
        final Animation leftSwipe = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.left_side);
        final Animation topSwipe = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.top_side);
        final Animation bottomSwipe = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.bottom_side);
        final Animation shake = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.shake); // viberate
        final Animation fadein = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fadein_anim);
        final Animation bounce = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.bounce);

        icon1.startAnimation(bottomSwipe);
        icon2.startAnimation(topSwipe);
        icon3.startAnimation(rightSwipe);
        icon4.startAnimation(leftSwipe);
        icon5.startAnimation(rightSwipe);

        bottomSwipe.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mainCircle.setVisibility(View.VISIBLE);
                mainCircle.startAnimation(fadein);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        fadein.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                icon1.startAnimation(shake);
                icon2.startAnimation(shake);
                icon3.startAnimation(shake);
                icon4.startAnimation(shake);
                icon5.startAnimation(shake);
                mainCircle.startAnimation(shake);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                leftExplore.setVisibility(View.VISIBLE);
                rightExplore.setVisibility(View.VISIBLE);
                logoName.setVisibility(View.VISIBLE);

                leftExplore.startAnimation(rightSwipe);
                rightExplore.startAnimation(leftSwipe);
                logoName.startAnimation(bounce);
                StartIntroActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void declareVar() {
        icon1 = (ImageView) findViewById(R.id.icon1);
        icon2 = (ImageView) findViewById(R.id.icon2);
        icon3 = (ImageView) findViewById(R.id.icon3);
        icon4 = (ImageView) findViewById(R.id.icon4);
        icon5 = (ImageView) findViewById(R.id.icon5);
        mainCircle = (ImageView) findViewById(R.id.icon6);
        leftExplore = (ImageView) findViewById(R.id.icon8);
        rightExplore = (ImageView) findViewById(R.id.icon7);
        logoName = (ImageView) findViewById(R.id.logoName);

        mainCircle.setVisibility(View.GONE);
        leftExplore.setVisibility(View.GONE);
        rightExplore.setVisibility(View.GONE);
        logoName.setVisibility(View.GONE);
    }

    private void StartIntroActivity() {
        new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                setLocal("ar");
                startActivity(new Intent(SplashActivity.this, _IntroductionActivity.class));
                finish();
            }
        }.start();
    }

    private void setLocal(String mComingLocal) {
        Resources res = getResources();

        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        Locale local = Locale.getDefault();
        if (mComingLocal.contains("ar")) {
            local = new Locale("ar", "eg");
        } else {
            local = new Locale("en", "us");
        }
        Locale.setDefault(local);
        conf.setLocale(local);
        conf.setLayoutDirection(local);
        res.updateConfiguration(conf,dm);

        SharedPreferences.Editor editor = getSharedPreferences("APP_DATA", MODE_PRIVATE).edit();
        editor.putString("LANG", "ar");
        editor.apply();
}
}
