package com.example.quan;

import android.app.Application;

import monitor.M;

/**
 * Created by xingquan.he on 2017/6/8.
 * Mr.Quan
 */

public class QuanApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        M.monitor().initConfig(this);
    }
}
