package demo.knowledgepoints.scheduledtask.iml;

import demo.untils.StringUntil;
import demo.untils.TimeUtil;

import java.lang.reflect.Method;

public class ScheduledTaskTot {

    /** ��Ҫִ�з������߳� */
    Runnable runnable;
    /** Ψһ��id������ɾ�� */
    String taskId;
    /** ��ʱ������Ҫִ�еķ����� */
    String className;
    /** ��ʱ������Ҫִ�еķ��� */
    String method;
    /** �״�ִ�еȴ�ʱ�� */
    long initialDelay;
    /** ���ʱ�� */
    long delay;

    /**
     * ����һ����Ҫ��ʱ������
     * @param taskId
     * @param className
     * @param method
     * @param initialDelay
     * @param delay
     * @param beginTime��ִ�п�ʼʱ�䣩
     * @param endTime��ִ�н���ʱ�䣩
     */
    public ScheduledTaskTot(String taskId, String className, String method, long initialDelay, long delay, String beginTime, String endTime) {
        this.taskId = taskId;
        this.className = className;
        this.method = method;
        this.initialDelay = initialDelay;
        this.delay = delay;
        // �ڴ���ʵ����ʱ�򣬳�ʼ���߳��࣬ͨ�������ȡҪִ�е����뷽����Ŀǰû�мӲ�������ҿ���������չ
        runnable = () -> {
            System.out.println("---------------------------------");
            try {
                //��beginTime �� endTime ֮���ִ�С�
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
