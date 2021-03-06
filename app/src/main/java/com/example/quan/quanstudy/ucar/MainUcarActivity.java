package com.example.quan.quanstudy.ucar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;
import com.example.quan.quanstudy.ucar.trip.TripFeeDetailActivity;
import com.example.quan.quanstudy.ucar.usercenter.FeedBackActivity;

import monitor.M;
import monitor.Keys;

/**
 * Created by xingquan.he on 2017/5/23.
 * Mr.Quan
 */

public class MainUcarActivity extends BaseActivity {

    private Button mTripFeeDemo;
    private Button mFeedBackDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initOnClickListener();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ucar;
    }

    @Override
    public void initView() {
        mTripFeeDemo = (Button) findViewById(R.id.tripfee_btn_ucar);
        mFeedBackDemo = (Button) findViewById(R.id.feedback_btn_ucar);
        initTitle(R.string.ucar);
        findViewById(R.id.back_title).setOnClickListener(this);
    }

    private void initOnClickListener() {
        mTripFeeDemo.setOnClickListener(this);
        mFeedBackDemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tripfee_btn_ucar:
                M.monitor().onEvent(mContext, Keys.UCAR_TRIPFEEDETAIL);
                gotoNextActivity(TripFeeDetailActivity.class);
                break;
            case R.id.feedback_btn_ucar:
                gotoNextActivity(FeedBackActivity.class);
                break;
            case R.id.back_title:
                finish();
            default:
                break;
        }
    }
}
