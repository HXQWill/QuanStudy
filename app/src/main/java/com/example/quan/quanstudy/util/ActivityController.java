package com.example.quan.quanstudy.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity管理集合
 * Created by xingquan.he on 2017/3/22.
 * Mr.Quan
 */

public class ActivityController {

    private static List<Activity> mActivityList = new ArrayList<>();

    public static void addActivity(Activity activity){
        mActivityList.add(activity);
    }

    public static void removeActivity(Activity activity){
        mActivityList.remove(activity);
    }

    public static void finishAll(){
        for(Activity activity : mActivityList){
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}
