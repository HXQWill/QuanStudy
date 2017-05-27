package com.example.quan.quanstudy.util;

/**
 * Created by xingquan.he on 2017/3/31.
 * Mr.Quan
 */

public class Utils {
    private static long lastClickTime;

    public static boolean isFastClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 800) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
