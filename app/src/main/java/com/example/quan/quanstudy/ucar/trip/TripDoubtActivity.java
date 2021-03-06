package com.example.quan.quanstudy.ucar.trip;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;

/**
 * Created by xingquan.he on 2017/5/23.
 * Mr.Quan
 */

public class TripDoubtActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ucar_tripdoubt;
    }

    @Override
    public void initView() {
        initTitle(R.string.trip_doubt);
        findViewById(R.id.back_title).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.back_title:
                finish();
            default:
                break;
        }
    }
}
