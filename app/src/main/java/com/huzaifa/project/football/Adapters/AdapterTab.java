package com.huzaifa.project.football.Adapters;


import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;

import com.huzaifa.project.football.Fragments.Player_info;
import com.huzaifa.project.football.Fragments.Team_info;
import com.huzaifa.project.football.Fragments.video_screen;
import com.huzaifa.project.football.Fragments.videos_display;

public class AdapterTab extends FragmentStatePagerAdapter {

    Fragment fragment = new video_screen();
    int NO_OF_TABS = 3;
    Context context;
    TabLayout tableLayout;
    ViewPager viewPager;
    Fragment f3;
    RelativeLayout relativeLayout;
    public AdapterTab(FragmentManager fm, Context context, TabLayout tableLayout,ViewPager viewPager,RelativeLayout relativeLayout) {
        super(fm);
        this.context=context;
        this.tableLayout = tableLayout;
        this.viewPager = viewPager;
        this.relativeLayout = relativeLayout;
    }
    public AdapterTab(FragmentManager f) {
        super(f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f=null;

        switch (position) {
            case 0:
               Fragment f1=new Team_info();
                f=f1;
                break;
            case 1:
                Fragment f2=new Player_info();
                f=f2;
                break;

            case 2:
                f3 =new videos_display(relativeLayout);
                f=f3;
                break;

        }

        return f;
    }



    @Override
    public int getCount() {
        return NO_OF_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

}
