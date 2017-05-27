package com.example.quan.quanstudy.ucar.trip;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;

import view.MoreWidget;

/**
 * Created by xingquan.he on 2017/5/23.
 * Mr.Quan
 */

public class TripFeeDetailActivity extends BaseActivity {

//    private Button mDoubtDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initOnClickListener();
        initMore();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ucar_tripfeedetail;
    }

    @Override
    public void initView() {
//        mDoubtDemo = (Button) findViewById(R.id.trip_doubt_btn_ucar);
        initTitle(R.string.trip_feedetail);
        findViewById(R.id.back_title).setOnClickListener(this);
    }

    private void initOnClickListener() {
//        mDoubtDemo.setOnClickListener(this);
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

    /**
     * 初始化更多，疑义，计价规则
     */
    private void initMore() {
        initTitleMore();
        addTitleMoreItem(R.drawable.trip_detail_doubt, getString(R.string.trip_doubt), new MoreWidget.ClickCallback() {
            @Override
            public void callback() {
                gotoNextActivity(TripDoubtActivity.class);
            }
        });
    }
}
