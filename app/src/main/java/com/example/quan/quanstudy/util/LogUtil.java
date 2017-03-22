package com.example.quan.quanstudy.util;

import android.text.TextUtils;
import android.util.Log;

/**
 * 更加强大的Log工具，全方位输出类-方法-行数-内容
 * tag自动产生，格式: customTagPrefix:className.methodName(L:lineNumber),
 * customTagPrefix为空时只输出：className.methodName(L:lineNumber)。
 *
 * Created by xingquan.he on 2017/3/22.
 * Mr.Quan
 */

public class LogUtil {

    private static final String customTagPrefix = "Quan_log";

    private LogUtil() {

    }

    private static String generateTag() {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String tag = "%s.%s(L:%d)";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = TextUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
        return tag;
    }

    public static void d(String content) {
        Log.d(generateTag(), content);
    }

    public static void d(String content, Throwable tr) {
        Log.d(generateTag(), content, tr);
    }
}
