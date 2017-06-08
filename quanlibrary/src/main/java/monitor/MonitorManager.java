package monitor;

import android.app.Application;
import android.content.Context;

/**
 * Created by xingquan.he on 2017/6/1.
 * umeng 官方方法
 */

public interface MonitorManager {

    void initConfig(Application application);

    void onPause(Context context,String activityName);

    void onResume(Context context,String activityName);

    void enableEncrypt(boolean enable);

    void onEvent(Context context,String key);

    void setDebugMode(boolean enable);
}
