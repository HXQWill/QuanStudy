package com.example.quan.quanstudy.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by xq.he on 2017/3/13.
 */

public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
    }

    public abstract int getLayoutId();

    public abstract void initView();

    protected void gotoNextActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
