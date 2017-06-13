package com.example.quan.quanstudy.ucar.usercenter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.base.BaseActivity;
import com.example.quan.util.Utils;

/**
 * Created by xingquan.he on 2017/6/2.
 * 意见反馈
 */

public class FeedBackActivity extends BaseActivity {
    private EditText mContentEt;
    private TextView mWatchWordsTv;
    private static final String DEFAULTNUM = "200";
    private static final int MAXNUM = 200;
    private TextView mCommitTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initOnClickListener();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ucar_feedback;
    }

    @Override
    public void initView() {
        mCommitTv = (TextView) findViewById(R.id.commit_tv_feedback);
        mCommitTv.setEnabled(false);
        mContentEt = (EditText) findViewById(R.id.content_et_feedback);
        mContentEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(mContentEt.getText().toString())) {
                    mCommitTv.setEnabled(false);
                } else {
                    mCommitTv.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = mContentEt.getText().length();
                if (length > MAXNUM) {
                    Toast.makeText(mContext, getString(R.string.input_feedback_content_long), Toast.LENGTH_SHORT).show();
                    String text = mContentEt.getText().toString()
                            .substring(0, MAXNUM - 1);
                    mContentEt.setText(text);
                    length = MAXNUM;
                }
                int left = MAXNUM - length;
                mWatchWordsTv.setText(String.format(getResources().getString(R.string.default_feedback_words), Integer.toString(left)));
            }
        });
        mWatchWordsTv = (TextView) findViewById(R.id.watchWords_tv_feedback);
        mWatchWordsTv.setText(String.format(getResources().getString(R.string.default_feedback_words), DEFAULTNUM));
        initTitle(R.string.feedback);
        findViewById(R.id.back_title).setOnClickListener(this);
    }

    private void initOnClickListener() {
        mCommitTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.commit_tv_feedback:
                Utils.stringFilter(mContentEt.getText().toString());
                //网络请求，成功后往下走；若失败，提示并留在当前页面
                Toast.makeText(mContext, getString(R.string.feedback_success), Toast.LENGTH_SHORT).show();
                hideInputMethod();
                finish();
                break;
            case R.id.back_title:
                finish();
            default:
                break;
        }
    }

}
