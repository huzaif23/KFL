package com.huzaifa.project.football;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.huzaifa.project.football.Fragments.fixture_fragment;

public class Fixtures extends BaseActivity  {

    public DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_fixtures,frameLayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl,new fixture_fragment());
        ft.addToBackStack(null);
        ft.commit();
//        final StickyListHeadersListView stick = (StickyListHeadersListView) findViewById(R.id.list);
//        fixture_adapter adapter = new fixture_adapter(getApplicationContext());
//        stick.addHeaderView(getLayoutInflater().inflate(R.layout.header, null));
//        stick.setDividerHeight(20);
//
//        stick.setDrawingListUnderStickyHeader(true);
//        stick.setAdapter(adapter);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            f.setEnterTransition(new Slide(Gravity.RIGHT));
//            f.setExitTransition(new Slide(Gravity.LEFT));
//        }

//        stick.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//       ft.replace(R.id.fl,new videos_display());
//                ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
//
//       ft.commit();
//                Toast.makeText(getApplicationContext(),"work"+position,Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }


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

