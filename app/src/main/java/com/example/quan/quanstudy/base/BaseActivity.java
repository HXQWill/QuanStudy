package com.example.quan.quanstudy.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by xq.he on 2017/3/13.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    public abstract int getLayoutId();

}
