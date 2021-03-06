package com.abha.chamber.abhachamber_android_app3.home;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.abha.chamber.abhachamber_android_app3.common.GenericModel;
import com.abha.chamber.abhachamber_android_app3.common.Helper;
import com.abha.chamber.abhachamber_android_app3.common.RecyclerItemClickListener;
import com.abha.chamber.abhachamber_android_app3.home.dashboard.HomeFragment;
import com.abha.chamber.abhachamber_android_app3.home.menu.MenuAdapter;

import org.abhacci.amado.abhachamber_android_app1.R;


import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeActivity extends AppCompatActivity {

    private ImageView backBtn, logo;
    private CircleImageView usernameImg;
    private TextView titleTv;
    private  DrawerLayout drawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        initMenu();

        setupToolbar();
    }

    private void initMenu() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        usernameImg = (CircleImageView) toolbar.findViewById(R.id.usernameImg);
        backBtn = (ImageView) toolbar.findViewById(R.id.backBtn);
        titleTv = (TextView) toolbar.findViewById(R.id.titleTv);
        logo = (ImageView) toolbar.findViewById(R.id.logo);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        RecyclerView menuRv = (RecyclerView) findViewById(R.id.menu_rv);

        usernameImg.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        TextView userNameTxt = (TextView) findViewById(R.id.userNameTxt);
        ImageView profileImage = (ImageView) findViewById(R.id.profileImage);
        ImageView helpBtn = (ImageView) findViewById(R.id.helpBtn);
        ImageView settingBtn = (ImageView) findViewById(R.id.settingBtn);

        titleTv.setTypeface(Helper.getTypeFace(this), Typeface.BOLD);
        userNameTxt.setTypeface(Helper.getTypeFace(this));

        Helper.setSrc4BackImg(backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container_frame, new HomeFragment()).addToBackStack(null).commit();

        final ArrayList<GenericModel> nav_items = new ArrayList<>();

        nav_items.add(new GenericModel(R.drawable.ic_login, "تسجيل الدخول."));
        nav_items.add(new GenericModel(R.drawable.ic_ecommerce, "الخدمات الالكترونية."));
        nav_items.add(new GenericModel(R.drawable.ic_admin, "إدارات الغرفة."));
        nav_items.add(new GenericModel(R.drawable.ic_work, "التوطين والتدريب."));
        nav_items.add(new GenericModel(R.drawable.ic_commitment, "اللجان النوعية."));
        nav_items.add(new GenericModel(R.drawable.ic_factory, "المنشآت الصغيرة والمتوسطة."));
        nav_items.add(new GenericModel(R.drawable.ic_elegant_lady, "سيدات الاعمال."));
        nav_items.add(new GenericModel(R.drawable.ic_network, "البحوث والمعلومات."));
        nav_items.add(new GenericModel(R.drawable.ic_seo, "الإعلام والعلاقات العامة."));
        nav_items.add(new GenericModel(R.drawable.ic_help, "عن الغرفة."));
        nav_items.add(new GenericModel(R.drawable.ic_talking, "إتصل بنا."));


        MenuAdapter nav_adapter = new MenuAdapter(this, nav_items);
        menuRv.setAdapter(nav_adapter);
        menuRv.addOnItemTouchListener(new RecyclerItemClickListener(this, menuRv, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(HomeActivity.this, nav_items.get(position).getName(), Toast.LENGTH_SHORT).show();
                        drawer.closeDrawers();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }
                })
        );


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer,
                toolbar,
                R.string.app_name,
                R.string.app_name);

        toggle.syncState();


    }


    public void setupToolbar(){
        titleTv.setVisibility(View.GONE);
        backBtn.setVisibility(View.GONE);
        logo.setVisibility(View.VISIBLE);
        usernameImg.setVisibility(View.VISIBLE);

    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            int count = getSupportFragmentManager().getBackStackEntryCount();
            if (count == 0 || count == 1) {
                finish();
            } else {
                super.onBackPressed();
            }
        }
    }
}
