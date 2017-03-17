package com.example.quan.quanstudy.transitionHelper.image;

import android.view.View;
import android.widget.ImageView;

import com.example.quan.quanlibrary.transition_helper.TransitionsHeleper;
import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.transitionHelper.BaseTransitionActivity;

/**
 * Created by xq.he on 2017/03/14.
 */

public class ImageActivity extends BaseTransitionActivity {

    private ImageView mStartImage;

    @Override
    public void initView() {
        mStartImage = (ImageView) findViewById(R.id.start_iv_image);
        mStartImage.setImageResource(R.mipmap.quan);
        mStartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionsHeleper.startActivity(ImageActivity.this, ImageDetailActivity.class, mStartImage, R.mipmap.quan);
                finish();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_image;
    }

}
