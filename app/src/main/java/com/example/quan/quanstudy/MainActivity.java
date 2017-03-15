package com.example.quan.quanstudy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quan.quanstudy.mvpLogin.view.LoginActivity;
import com.example.quan.quanstudy.objectAnimator.MainAnimatorActivity;
import com.example.quan.quanstudy.transitionHelper.MainTransitionActivity;
import com.example.quan.quanstudy.viewDemo.ViewActivity;
import com.example.quan.quanstudy.base.BaseActivity;

/**
 * Created By Quan 2017-3-7
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button mMVPDemo;
    private Button mViewDemo;
    private Button mTransitionDemo;
    private Button mObjectAnimatorDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initOnClickListener();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mMVPDemo = (Button) findViewById(R.id.mvp_btn_main);
        mViewDemo = (Button) findViewById(R.id.view_btn_main);
        mTransitionDemo = (Button) findViewById(R.id.transition_btn_main);
        mObjectAnimatorDemo = (Button) findViewById(R.id.animator_btn_main);
    }

    private void initOnClickListener() {
        mMVPDemo.setOnClickListener(this);
        mViewDemo.setOnClickListener(this);
        mTransitionDemo.setOnClickListener(this);
        mObjectAnimatorDemo.setOnClickListener(this);
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
            case R.id.transition_btn_main:
                gotoNextActivity(MainTransitionActivity.class);
                break;
            case R.id.animator_btn_main:
                gotoNextActivity(MainAnimatorActivity.class);
                break;
            default:
                break;
        }
    }

}
