package com.xs.lifepay;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.xs.lifepay.dialog.AppHelpFragment;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener{

    private TextView _tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        Toolbar _toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawer,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navi_main);
        navigationView.setNavigationItemSelectedListener(this);

        _tv = (TextView) findViewById(R.id.tv_main);
        final FloatingActionButton _fb = (FloatingActionButton) findViewById(R.id.fb_main);
        RxView.clicks(_fb).subscribe(aVoid -> Snackbar.make(drawer,"this is LifePay.",Snackbar.LENGTH_LONG).show());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        boolean itemFlag = super.onOptionsItemSelected(item);
        switch (id) {
            case R.id.action_edit:
                itemFlag = true;
                EditAcitivity.startActivity(MainActivity.this);
                break;
            case R.id.action_zoom:
                itemFlag = true;
                ExploreActivity.startActivity(MainActivity.this);
                break;
            case R.id.action_setting:
                itemFlag = true;
                break;
            case R.id.version:
                itemFlag = true;
                AppHelpFragment.getInstance("LifePay is lalalal..")
                        .show(getSupportFragmentManager(),null);
                break;
            case android.R.id.home:
                itemFlag = true;
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);
                break;
        }

        return itemFlag;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:

                break;
            case R.id.item2:

                break;
            case R.id.item3:
                break;
            case R.id.item4:
                break;
            case R.id.nav_send:

                break;
            case R.id.nav_share:

                break;
        }
        _tv.setText(item.getTitle());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();

    }

    private void setToolBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
