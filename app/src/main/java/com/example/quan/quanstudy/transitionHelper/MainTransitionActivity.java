package com.example.quan.quanstudy.transitionHelper;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.transitionHelper.image.ImageActivity;

public class MainTransitionActivity extends BaseTransitionActivity implements View.OnClickListener{

    private Button mImageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initOnClickListener();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_transition;
    }

    @Override
    public void initView() {
        mImageBtn = (Button) findViewById(R.id.image_btn_transition);
    }

    private void initOnClickListener() {
        mImageBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_btn_transition:
                gotoNextActivity(ImageActivity.class);
                break;
            default:
                break;
        }
    }
}
