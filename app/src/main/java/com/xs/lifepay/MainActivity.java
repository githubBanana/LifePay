package com.xs.lifepay;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.jakewharton.rxbinding.view.RxView;
import com.xs.lifepay.dialog.AppHelpFragment;

public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener{
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        Toolbar _toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawer,R.string.navigation_drawer_open,R.string.navigation_drawer_close){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);//slideOffset = 0 :Disable the Hamburger icon animation
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navi_main);
        navigationView.setNavigationItemSelectedListener(this);

        final FloatingActionButton _fb = (FloatingActionButton) findViewById(R.id.fb_main);
//        RxView.clicks(_fb).subscribe(aVoid -> Snackbar.make(drawer,"this is LifePay.",Snackbar.LENGTH_LONG).show());
        initView(navigationView);
    }
    private void initView(NavigationView container) {
        final ImageView _ivHead = (ImageView) container.getHeaderView(0).findViewById(R.id.iv_main_navi_head);
        Uri uri = Uri.parse("http://weidongzn.com//Files/upload/201605/9/i20160509155458524.jpg");
        Glide.with(getApplicationContext()).load(uri).asBitmap().thumbnail(0.6f).centerCrop().placeholder(R.mipmap.ic_launcher).into(new BitmapImageViewTarget(_ivHead) {
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), resource);
                roundedBitmapDrawable.setCircular(true);
                getView().setImageDrawable(roundedBitmapDrawable);
            }
        });

        final TextView _tvName = (TextView) container.getHeaderView(0).findViewById(R.id.tv_username);
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

}
