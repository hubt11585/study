package demo.knowledgepoints.scheduledtask.iml;

import demo.untils.StringUntil;
import demo.untils.TimeUtil;

import java.lang.reflect.Method;

public class ScheduledTaskTot {

    /** 需要执行方法的线程 */
    Runnable runnable;
    /** 唯一的id用于增删改 */
    String taskId;
    /** 定时任务需要执行的方法类 */
    String className;
    /** 定时任务需要执行的方法 */
    String method;
    /** 首次执行等待时间 */
    long initialDelay;
    /** 间隔时间 */
    long delay;

    /**
     * 创建一个需要定时的任务
     * @param taskId
     * @param className
     * @param method
     * @param initialDelay
     * @param delay
     * @param beginTime（执行开始时间）
     * @param endTime（执行结束时间）
     */
    public ScheduledTaskTot(String taskId, String className, String method, long initialDelay, long delay, String beginTime, String endTime) {
        this.taskId = taskId;
        this.className = className;
        this.method = method;
        this.initialDelay = initialDelay;
        this.delay = delay;
        // 在创建实例的时候，初始化线程类，通过反射获取要执行的类与方法，目前没有加参数，大家可以自行扩展
        runnable = () -> {
            System.out.println("---------------------------------");
            try {
                //在beginTime 到 endTime 之间才执行。
                if(StringUntil.isNotBlank(beginTime) && StringUntil.isNotBlank(endTime)){
                    if(TimeUtil.getTimeMillis(beginTime) - System.currentTimeMillis() >= 0 && TimeUtil.getTimeMillis(endTime) - System.currentTimeMillis() <= 0){
                        Class<?> cls = Class.forName(className);
                        Method method1 = cls.getMethod(method);
                        method1.invoke(cls.newInstance(),null);
                    }
                }else{
                    Class<?> cls = Class.forName(className);
                    Method method1 = cls.getMethod(method);
                    method1.invoke(cls.newInstance(),null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public long getInitialDelay() {
        return initialDelay;
    }

    public void setInitialDelay(long initialDelay) {
        this.initialDelay = initialDelay;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }
}
