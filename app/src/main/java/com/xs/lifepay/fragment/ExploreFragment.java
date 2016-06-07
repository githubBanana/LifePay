package com.xs.lifepay.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.xs.lifepay.R;
import com.xs.lifepay.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-07 15:22
 * @email Xs.lin@foxmail.com
 */
public class ExploreFragment extends Fragment{
    private static final String TAG = "ExploreFragment";

    private PullLoadMoreRecyclerView _pull;
    private RecyclerViewAdapter      _adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_layout,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        _pull = (PullLoadMoreRecyclerView) view.findViewById(R.id.pull_loadmore_recycle_view );
        _pull.setPushRefreshEnable(false);
        _pull.setLinearLayout();

        _adapter = new RecyclerViewAdapter(getActivity(),setList());
        _pull.setAdapter(_adapter);

        _pull.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                Log.e(TAG, "onRefresh: " );
                getData();
            }

            @Override
            public void onLoadMore() {
                Log.e(TAG, "onLoadMore: " );
            }
        });

    }
    private void getData() {
        new Handler().postDelayed(() -> {
            _adapter.getDataList().addAll(setList());
            _adapter.notifyDataSetChanged();
            _pull.setPullLoadMoreCompleted();
        },3000);
    }
    private List<String> setList() {
        List<String> dataList = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            dataList.add("Frist" + i);
        }
        return dataList;
    }

}
