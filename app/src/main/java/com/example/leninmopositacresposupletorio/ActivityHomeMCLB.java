package com.example.leninmopositacresposupletorio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ActivityHomeMCLB extends AppCompatActivity {


    private String nombre;
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem personal,bissnes;
    PagesController_MCLB adapterPagesController_aj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_mclb);
    }
}