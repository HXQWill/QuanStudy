package monitor;

import android.app.Application;
import android.content.Context;

import com.tendcloud.tenddata.TCAgent;
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

    @Override
    public void initConfig(Application application) {
        TCAgent.LOG_ON = true;
        // App ID: 在TalkingData创建应用后，进入数据报表页中，在“系统设置”-“编辑应用”页面里查看App ID。
        // 渠道 ID: 是渠道标识符，可通过不同渠道单独追踪数据。
        TCAgent.init(application, "58A945F103B347F9A0BBACDA083F8189", "Personal");
        // 如果已经在AndroidManifest.xml配置了App ID和渠道ID，调用TCAgent.init(this)即可；或与AndroidManifest.xml中的对应参数保持一致。

        TCAgent.setReportUncaughtExceptions(true);//自动捕获并上传
        TCAgent.setAntiCheatingEnabled(application,true);//开启反作弊功能
    }

    //获取正确的新增用户、活跃用户、启动次数、使用时长等基本数据
    @Override
    public void onPause(Context context,String activityName) {
        MobclickAgent.onPause(context);
        TCAgent.onPageEnd(context, activityName);
    }

    //获取正确的新增用户、活跃用户、启动次数、使用时长等基本数据
    @Override
    public void onResume(Context context,String activityName) {
        MobclickAgent.onResume(context);
        TCAgent.onPageStart(context, activityName);
    }

    //如果enable为true，SDK会对日志进行加密。加密模式可以有效防止网络攻击，提高数据安全性。
    @Override
    public void enableEncrypt(boolean enable) {
        MobclickAgent.enableEncrypt(enable);//6.0.0版本及以后
    }

    @Override
    public void onEvent(Context context, String key) {
        MobclickAgent.onEvent(context,key);
        TCAgent.onEvent(context,key);
    }

    // 打开debug模式。然后可以打开应用，触发所埋点的按钮部分。
    // 在开发环境里的logcat里查看日志，通过 MobclickAgent 进行筛选就可以筛选出友盟的日志，
    // 看下日志中有无event信息即可。
    @Override
    public void setDebugMode(boolean enable) {
        MobclickAgent.setDebugMode(enable);
    }

}
