package com.example.quan.quanstudy.objectAnimator;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;
import com.example.quan.quanstudy.util.Utils;

import edittext_firework.FireworkView;

/**
 * Created by xingquan.he on 2017/3/20.
 * Mr.Quan
 */

public class FireWorkActivity extends BaseActivity{

    private EditText mEditText;
    private FireworkView mFireworkView;
    private RelativeLayout mLayout;
    private TextView mDayMode;
    private TextView mNightMode;

    @Override
    public int getLayoutId() {
        return R.layout.activity_animator_firework;
    }

    @Override
    public void initView() {
        mLayout = (RelativeLayout) findViewById(R.id.layout_rl_animator_firework);
        mDayMode = (TextView) findViewById(R.id.day_tv_animator_firework);
        mDayMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.isFastClick();
                mLayout.setBackgroundColor(0xFFFFFFFF);
            }
        });
        mNightMode = (TextView) findViewById(R.id.night_tv_animator_firework);
        mNightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.isFastClick();
                mLayout.setBackgroundColor(0xFF000000);
            }
        });
        mEditText = (EditText) findViewById(R.id.edit_et_animator_firework);

        mFireworkView = (FireworkView) findViewById(R.id.fire_fw_animator_firework);
        mFireworkView.bindEditText(mEditText);
    }
}
