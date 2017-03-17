package com.example.quan.quanstudy.design;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.quan.quanstudy.R;

/**
 * Created by xingquan.he on 2017/3/16.
 * Mr.Quan
 * AppBarLayout + CollapsingToolbarLayout
 * CoordinatorLayout 可以协调子View，做隐藏或者显示
 * ActionBar -> Toolbar，规范的标题栏 -> CollapsingToolbarLayout 可折叠伸缩的Toolbar
 */

public class CollapsingActivity extends AppCompatActivity {
    private CollapsingToolbarLayout mCollapsingToolbarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_collapsing);

        setSupportActionBar((Toolbar)findViewById(R.id.top_tb_design_collapsing));

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_ctb_design);
        mCollapsingToolbarLayout.setTitle("QuanTitle");

        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);

        //沉浸式内容 Content scrim
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.bg_purple));
        mCollapsingToolbarLayout.setContentScrim(getResources().getDrawable(R.mipmap.quan)); // 标题栏->图片
        //沉浸状态栏 Status bar scrim
//        mCollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.bg_teal_light));
//        mCollapsingToolbarLayout.setStatusBarScrim(getResources().getDrawable(R.mipmap.quan));  // 标题栏+图片
    }
}
