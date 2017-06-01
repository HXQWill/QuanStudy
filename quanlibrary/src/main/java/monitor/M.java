package monitor;

/**
 * Created by xingquan.he on 2017/6/1.
 * Mr.Quan
 */

public class M {
    private M(){

    }

    public static MonitorManager monitor() {
        if(Ext.monitor == null){
            MonitorManagerImpl.registerInstance();
        }
        return Ext.monitor;
    }

    public final static class Ext{
        private static MonitorManager monitor;

        public static void setMonitor(MonitorManager monitor) {
            Ext.monitor = monitor;
        }

    }
}
