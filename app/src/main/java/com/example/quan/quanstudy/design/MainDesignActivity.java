package com.example.quan.quanstudy.design;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;
import com.example.quan.quanstudy.design.tablayout.TabLayoutActivity;

/**
 * Created by xingquan.he on 2017/3/16.
 * Mr.Quan
 */

public class MainDesignActivity extends BaseActivity {
    private Button mFabBtn;
    private Button mScrollBtn;
    private Button mCollapsingBtn;
    private Button mTablayoutBtn;
    private TextView mSelectorTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initOnClickListener();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_design;
    }

    @Override
    public void initView() {
        mFabBtn = (Button) findViewById(R.id.fab_btn_design);
        mScrollBtn = (Button) findViewById(R.id.scroll_btn_design);
        mCollapsingBtn = (Button) findViewById(R.id.collapsing_btn_design);
        mTablayoutBtn = (Button) findViewById(R.id.tablayout_btn_design);
        mSelectorTv = (TextView) findViewById(R.id.selector_tv_design);
    }

    private void initOnClickListener() {
        mFabBtn.setOnClickListener(this);
        mScrollBtn.setOnClickListener(this);
        mCollapsingBtn.setOnClickListener(this);
        mTablayoutBtn.setOnClickListener(this);
        mSelectorTv.setOnClickListener(this);
    }

    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.fab_btn_design:
                gotoNextActivity(FloatingActionBarActivity.class);
                break;
            case R.id.scroll_btn_design:
                gotoNextActivity(ScrollActivity.class);
                break;
            case R.id.collapsing_btn_design:
                gotoNextActivity(CollapsingActivity.class);
                break;
            case R.id.tablayout_btn_design:
                gotoNextActivity(TabLayoutActivity.class);
                break;
            case R.id.selector_tv_design:
                Toast.makeText(MainDesignActivity.this,"selector_tv_design",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
