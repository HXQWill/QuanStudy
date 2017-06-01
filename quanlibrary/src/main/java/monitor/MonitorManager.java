package monitor;

import android.content.Context;

/**
 * Created by xingquan.he on 2017/6/1.
 * umeng 官方方法
 */

public interface MonitorManager {

    void onPause(Context context);

    void onResume(Context context);

    void enableEncrypt(boolean enable);

    void onEvent(Context context,String key);

    void setDebugMode(boolean enable);
}
