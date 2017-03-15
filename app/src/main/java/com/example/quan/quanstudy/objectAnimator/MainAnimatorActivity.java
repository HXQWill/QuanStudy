package com.example.quan.quanstudy.objectAnimator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;

public class MainAnimatorActivity extends BaseActivity implements View.OnClickListener{

    private Button mFirstBtn;
    private Button mPathBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initOnClickListener();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_animator;
    }

    @Override
    public void initView() {
        mFirstBtn = (Button) findViewById(R.id.first_btn_animator);
        mPathBtn = (Button) findViewById(R.id.path_btn_animator);
    }

    private void initOnClickListener() {
        mFirstBtn.setOnClickListener(this);
        mPathBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first_btn_animator:
                gotoNextActivity(FirstClassActivity.class);
                break;
            case R.id.path_btn_animator:
                gotoNextActivity(PathActivity.class);
                break;
            default:
                break;
        }
    }
}
