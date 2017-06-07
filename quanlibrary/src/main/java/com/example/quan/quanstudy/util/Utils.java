package com.example.quan.quanstudy.util;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * 过滤特殊字符
     */
    public static String stringFilter(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String regEx = "[<>'\"]";
        str = str.replaceAll("&nbsp;", "").replaceAll("&amp;", "")
                .replaceAll("#160;", "").replaceAll("&lt;", "")
                .replaceAll("&gt;", "").replaceAll("&quot;", "")
                .replaceAll("&#60;", "").replaceAll("&#62;", "")
                .replaceAll("&#38;", "").replaceAll("&#34;", "");
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

}
