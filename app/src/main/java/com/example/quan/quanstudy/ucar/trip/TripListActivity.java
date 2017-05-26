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

public class TripListActivity extends BaseActivity {

    private Button mDoubtDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initOnClickListener();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ucar_triplist;
    }

    @Override
    public void initView() {
        mDoubtDemo = (Button) findViewById(R.id.trip_doubt_btn_ucar);
    }

    private void initOnClickListener() {
        mDoubtDemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.trip_doubt_btn_ucar:
                gotoNextActivity(TripDoubtActivity.class);
                break;
            default:
                break;
        }
    }
}
