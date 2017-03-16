package com.example.quan.quanstudy.design;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.quan.quanstudy.R;

/**
 * Created by xingquan.he on 2017/3/16.
 * Mr.Quan
 * 伸缩 —— CoordinatorLayout + AppBarLayout + NestedScrollView
 * AppBarLayout是一个实现了很多material designs特性的垂直的LinearLayout，它能响应滑动事件。
 */

public class ScrollActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_scroll);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("QuanTitle");
        setSupportActionBar(mToolbar);
    }
}
