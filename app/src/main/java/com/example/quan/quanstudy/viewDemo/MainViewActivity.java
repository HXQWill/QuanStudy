package com.example.quan.quanstudy.viewDemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;

/**
 * Created by xingquan.he on 2017/3/15.
 * Mr.Quan
 */

public class MainViewActivity extends BaseActivity implements View.OnClickListener{
    private Button mSimpleBtn;
    private Button mDiyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initOnClickListener();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_view;
    }

    @Override
    public void initView() {
        mSimpleBtn = (Button) findViewById(R.id.simple_btn_view);
        mDiyBtn = (Button) findViewById(R.id.diy_btn_view);
    }

    private void initOnClickListener() {
        mSimpleBtn.setOnClickListener(this);
        mDiyBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.simple_btn_view:
                gotoNextActivity(SimpleActivity.class);
                break;
            case R.id.diy_btn_view:
                gotoNextActivity(ThreeDiyViewActivity.class);
                break;
            default:
                break;
        }
    }
}
