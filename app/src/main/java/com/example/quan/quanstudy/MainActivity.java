package com.example.quan.quanstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quan.quanstudy.MVP_login.view.LoginActivity;

/**
 * Created By Quan 2017-3-7
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mMVPTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initOnClickListener();
    }

    private void initView() {
        mMVPTest = (Button) findViewById(R.id.mvp_btn_main);
    }

    private void initOnClickListener() {
        mMVPTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mvp_btn_main:
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
                break;
        }
    }
}
