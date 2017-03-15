package com.example.quan.quanstudy.viewDemo;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quan.quanstudy.R;

/**
 * Created by xingquan.he on 2017/3/15.
 * Mr.Quan
 * 组合控件
 */

public class TitleView extends FrameLayout {

    private ImageView mBackImage;

    private TextView mTitleText;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.title, this);
        mTitleText = (TextView) findViewById(R.id.content_tv_title);
        mBackImage = (ImageView) findViewById(R.id.back_iv_title);
        mBackImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
    }


    //可扩展性
    public void setTitleContent(String text) {
        mTitleText.setText(text);
    }

    //可扩展性
    public void setBackImageListener(OnClickListener l) {
        mBackImage.setOnClickListener(l);
    }
}
