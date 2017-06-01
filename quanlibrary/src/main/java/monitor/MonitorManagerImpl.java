package monitor;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by xingquan.he on 2017/6/1.
 * Mr.Quan
 */

public class MonitorManagerImpl implements MonitorManager {
    private static MonitorManagerImpl instance;

    public static void registerInstance() {
        if (instance == null) {
            synchronized (MonitorManagerImpl.class) {
                if (instance == null) {
                    instance = new MonitorManagerImpl();
                    M.Ext.setMonitor(instance);
                }
            }
        }
    }

    //获取正确的新增用户、活跃用户、启动次数、使用时长等基本数据
    @Override
    public void onPause(Context context) {
        MobclickAgent.onPause(context);
    }

    //获取正确的新增用户、活跃用户、启动次数、使用时长等基本数据
    @Override
    public void onResume(Context context) {
        MobclickAgent.onResume(context);
    }

    //如果enable为true，SDK会对日志进行加密。加密模式可以有效防止网络攻击，提高数据安全性。
    @Override
    public void enableEncrypt(boolean enable) {
        MobclickAgent.enableEncrypt(enable);//6.0.0版本及以后
    }

    @Override
    public void onEvent(Context context, String key) {
        MobclickAgent.onEvent(context,key);
    }

    // 打开debug模式。然后可以打开应用，触发所埋点的按钮部分。
    // 在开发环境里的logcat里查看日志，通过 MobclickAgent 进行筛选就可以筛选出友盟的日志，
    // 看下日志中有无event信息即可。
    @Override
    public void setDebugMode(boolean enable) {
        MobclickAgent.setDebugMode(enable);
    }

}
