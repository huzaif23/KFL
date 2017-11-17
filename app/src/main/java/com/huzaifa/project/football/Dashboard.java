package com.huzaifa.project.football;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.huzaifa.project.football.Adapters.AdapterTab;

import java.util.List;

public class Dashboard extends BaseActivity  {

List<Model> models;
    private int Resources[] = {
            android.R.drawable.ic_menu_camera,android.R.drawable.ic_menu_gallery,android.R.drawable.ic_menu_slideshow
    };
    DrawerLayout drawerLayout;
    TabLayout tabLayout;
    RelativeLayout relativeLayout;
    CollapsingToolbarLayout cpl;
    static AppBarLayout appBarLayout;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_dashboard,frameLayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        relativeLayout = (RelativeLayout) findViewById(R.id.rlayout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

         cpl = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        cpl.setTitle("Barcelona");
        cpl.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        ViewPager vp = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tabL);
        AdapterTab adapterTab = new AdapterTab(getSupportFragmentManager(),Dashboard.this,tabLayout,vp,relativeLayout);
        vp.setAdapter(adapterTab);
        tabLayout.setupWithViewPager(vp);
        for (int i=0 ; i< Resources.length;i++) {
            tabLayout.getTabAt(i).setIcon(Resources[i]);
        }

}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

