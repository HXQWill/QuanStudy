package com.example.quan.quanstudy.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quan.quanstudy.R;
import com.example.quan.quanstudy.util.ActivityController;
import com.example.quan.quanstudy.util.CrashHandler;
import com.example.quan.quanstudy.util.LogUtil;
import com.example.quan.quanstudy.util.Utils;

import monitor.M;
import view.MoreWidget;

/**
 * Created by xq.he on 2017/3/13.
 */

public abstract class BaseActivity extends Activity implements View.OnClickListener {

    public Context mContext;

    private MoreWidget more_widget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        M.monitor().enableEncrypt(true);
        mContext = this;
        setContentView(getLayoutId());
        initView();
        LogUtil.d(getClass().getName());
        ActivityController.addActivity(this);
        CrashHandler.getInstance().init(getApplicationContext());
    }

    @Override
    protected void onPause() {
        super.onPause();
        M.monitor().onPause(mContext,getActivityName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        M.monitor().onResume(mContext,getActivityName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
    }

    public abstract int getLayoutId();

    public abstract void initView();

    protected void gotoNextActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (Utils.isFastClick()) {
            return;
        }
    }

    public void initTitle(int titleReId) {
        TextView titleTx = (TextView) findViewById(R.id.base_title);
        titleTx.setText(getString(titleReId));
    }

    public void initTitleMore() {
        ImageView more = (ImageView) findViewById(R.id.more);
        if (more != null) {
            more.setVisibility(View.VISIBLE);
            more_widget = (MoreWidget) findViewById(R.id.more_layout);
            more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (more_widget != null) {
                        more_widget.show();
                    }
                }
            });
        }
    }

    public void removeAllMoreItem() {
        if (more_widget != null) {
            more_widget.removeAllItems();
        }
    }

    public void addTitleMoreItem(String iconUrl, String content, MoreWidget.ClickCallback clickCallback) {
        if (more_widget != null) {
            more_widget.addItem(iconUrl, content, clickCallback);
        }
    }

    public void addTitleMoreItem(int iconId, String content, MoreWidget.ClickCallback clickCallback) {
        if (more_widget != null) {
            more_widget.addItem(iconId, content, clickCallback);
        }
    }

    /**
     * 隐藏软键盘
     */
    public void hideInputMethod() {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null && this.getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * 得到Activities栈顶的Activity名称
     */
    private String getActivityName(){
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.RunningTaskInfo info = manager.getRunningTasks(1).get(0);
        return info.topActivity.getShortClassName(); //类名
    }

}
