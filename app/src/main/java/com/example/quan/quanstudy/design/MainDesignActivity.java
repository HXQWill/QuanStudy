package com.example.quan.quanstudy.design;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;

/**
 * Created by xingquan.he on 2017/3/16.
 * Mr.Quan
 */

public class MainDesignActivity extends BaseActivity implements View.OnClickListener{
    private Button mFabBtn;
    private Button mScrollBtn;
    private Button mCollapsingBtn;

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
    }

    private void initOnClickListener() {
        mFabBtn.setOnClickListener(this);
        mScrollBtn.setOnClickListener(this);
        mCollapsingBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
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
            default:
                break;
        }
    }
}
