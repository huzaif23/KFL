package com.huzaifa.project.football;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
        {
            public DrawerLayout drawer;
            public  ActionBarDrawerToggle toggle;
         Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        handler = new Handler();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

      toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
            @Override
            protected void onPostCreate(Bundle savedInstanceState) {
                super.onPostCreate(savedInstanceState);
                toggle.syncState();
            }
            @Override
            public void onConfigurationChanged(Configuration newConfig) {
                super.onConfigurationChanged(newConfig);
                toggle.onConfigurationChanged(newConfig);
            }



            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {
               final int id = item.getItemId();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        smoothScroll(id);
                    }
                },260);

                return true;
            }

            private void smoothScroll(int id) {
                Intent intent;
                switch (id ) {
                    case R.id.nav_player:
                        intent = new Intent(this,Players.class);
                  startActivity(intent);
                        break;
                    case R.id.nav_teams:
                        intent = new Intent(this,Team_list.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_points_table:
                        intent = new Intent(this,Table_points.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_fixture:
                        intent = new Intent(this,Fixtures.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_video:
                        intent = new Intent(this,Video_page.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_contact:
                        intent = new Intent(this,Dashboard.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_venue:
                        intent = new Intent(this,Venue.class);
                        startActivity(intent);
                        break;
                }
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
               drawer.closeDrawer(GravityCompat.START);
            }
        }



