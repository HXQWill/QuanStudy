package com.example.quan.quanstudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quan.quanstudy.MVP_login.view.LoginActivity;
import com.example.quan.quanstudy.ViewDemo.ViewActivity;
import com.example.quan.quanstudy.base.BaseActivity;

/**
 * Created By Quan 2017-3-7
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button mMVPTest;
    private Button mViewDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initOnClickListener();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private void initView() {
        mMVPTest = (Button) findViewById(R.id.mvp_btn_main);
        mViewDemo = (Button) findViewById(R.id.view_btn_main);
    }

    private void initOnClickListener() {
        mMVPTest.setOnClickListener(this);
        mViewDemo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mvp_btn_main:
                gotoNextActivity(LoginActivity.class);
                break;
            case R.id.view_btn_main:
                gotoNextActivity(ViewActivity.class);
                break;
            default:
                break;
        }
    }

    private void gotoNextActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
