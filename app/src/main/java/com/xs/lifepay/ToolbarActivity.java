package com.xs.lifepay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-06 15:32
 * @email Xs.lin@foxmail.com
 */
public abstract class ToolbarActivity extends AppCompatActivity {
    private static final String TAG = "ToolbarActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutView());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
    }
    public void setDisplayHomeAsUpEnabled(boolean enabled) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void setHomeAsUpIndicator(int resId) {
        getSupportActionBar().setHomeAsUpIndicator(resId);
    }
    public void setToolbarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
    protected abstract int getLayoutView();
    protected abstract void init();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
