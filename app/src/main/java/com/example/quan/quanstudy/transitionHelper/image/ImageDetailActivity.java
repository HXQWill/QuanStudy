package com.example.quan.quanstudy.transitionHelper.image;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.quan.quanlibrary.transition_helper.TransitionsHeleper;
import com.example.quan.quanlibrary.transition_helper.bean.InfoBean;
import com.example.quan.quanlibrary.transition_helper.method.ColorShowMethod;
import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.transitionHelper.BaseTransitionActivity;


/**
 * Created by xq.he on 2017/3/14.
 */

public class ImageDetailActivity extends BaseTransitionActivity {
    private ImageView mEndImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TransitionsHeleper.getInstance()
                .setShowMethod(new ColorShowMethod(R.color.bg_teal_light,
                        R.color.bg_purple) {
                    @Override
                    public void loadCopyView(InfoBean bean, ImageView copyView) {
                        copyView.setImageResource(bean.getImgId());
                    }
                    @Override
                    public void loadTargetView(InfoBean bean, ImageView targetView) {
                        targetView.setImageResource(bean.getImgId());
                    }

                }).show(this, mEndImage);
    }

    @Override
    public void initView() {
        mEndImage = (ImageView) findViewById(R.id.end_iv_image);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_imagedetail;
    }
}
