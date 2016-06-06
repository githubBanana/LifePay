package com.xs.lifepay;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-06 15:10
 * @email Xs.lin@foxmail.com
 */
public class EditAcitivity extends ToolbarActivity {
    private static final String TAG = "EditAcitivity";

    public static void startActivity(Activity content) {
        Intent intent = new Intent(content,EditAcitivity.class);
        content.startActivity(intent);
    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_edit_layout;
    }

    @Override
    protected void init() {
        setDisplayHomeAsUpEnabled(true);
        setTitle("Notify");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_edit_layout);

      /* 为了让左上角android.R.id.home 有选择动画
      ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(EditAcitivity.this,drawer,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.notify_edit) {
            DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_edit_layout);
            drawerLayout.openDrawer(GravityCompat.END);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_edit_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.END))
            drawerLayout.closeDrawer(GravityCompat.END);
        else
            super.onBackPressed();
    }
}
