package com.example.quan.quanstudy.design.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.quan.quanstudy.R;

/**
 * Created by xingquan.he on 2017/3/17.
 * Mr.Quan
 * TabLayout提供了一个水平的布局用来展示Tabs
 */

public class TabLayoutActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_tablayout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.top_tb_design_tablayout);
        toolbar.setTitle("权-底部Tab");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mViewPager = (ViewPager) findViewById(R.id.center_vp_design_tablayout);
        SimpleFragmentPagerAdapter pagerAdapter =
                new SimpleFragmentPagerAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(pagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.bottom_tl_design_tablayout);
        mTabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(pagerAdapter.getTabView(i));
            }
        }

//        viewPager.setCurrentItem(1);
        mTabLayout.getTabAt(0).getCustomView().setSelected(true);

    }
}


