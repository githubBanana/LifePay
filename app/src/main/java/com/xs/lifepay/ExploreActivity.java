package com.xs.lifepay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.jakewharton.rxbinding.view.RxView;
import com.xs.lifepay.fragment.ExploreFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-06 17:07
 * @email Xs.lin@foxmail.com
 */
public class ExploreActivity extends AppCompatActivity
implements TextWatcher{
    private static final String TAG = "ExploreActivity";

    @Bind(R.id.iv_explore_delete) ImageView  _ivExplore;
    @Bind(R.id.et_explore_edit)   EditText   _etExplore;

    public static void startActivity(Activity content) {
        Intent intent = new Intent(content,ExploreActivity.class);
        content.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_layout);
        ButterKnife.bind(this);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.explore_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(null);
        _ivExplore.setVisibility(View.INVISIBLE);
        _etExplore.addTextChangedListener(this);
        RxView.clicks(_ivExplore).subscribe(aVoid -> _etExplore.setText(null));

        commitFragment();
    }

    private void commitFragment() {
        ExploreFragment fragment = new ExploreFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container,fragment).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() == 0)
            _ivExplore.setVisibility(View.INVISIBLE);
        else {
            Log.e(TAG, "onTextChanged: "+s );
            _ivExplore.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
