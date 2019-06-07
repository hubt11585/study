package demo.knowledgepoints.scheduledtask.inf;

import demo.knowledgepoints.scheduledtask.iml.ScheduledTaskTot;

public interface ScheduledService {

    /**
     * 添加一个任务
     * @author Eric
     * @date 16:14 2019/3/12
     * @params runnable
     * @params taskId
     * @params initialDelay 初次等待 毫秒
     * @params delay 间隔时间 毫秒（不延迟）
     * @throws
     * @return boolean
     **/
    boolean addFixedTask(ScheduledTaskTot scheduledTaskTot);

    /**
     * 添加一个任务
     * @author Eric
     * @date 16:14 2019/3/12
     * @params runnable
     * @params taskId
     * @params initialDelay 初次等待 毫秒
     * @params delay 间隔时间 毫秒（延迟）
     * @throws
     * @return boolean
     **/
    boolean addTask(ScheduledTaskTot scheduledTaskTot);

    /**
     * 修改一个任务
     * @author Eric
     * @date 16:14 2019/3/12
     * @params runnable
     * @params taskId
     * @params initialDelay 初次等待 毫秒
     * @params delay 间隔时间 毫秒
     * @throws
     * @return boolean
     **/
    boolean updateTask(ScheduledTaskTot scheduledTaskTot) throws InterruptedException;

    /**
     * 移除一个任务
     * @author Eric
     * @date 16:14 2019/3/12
     * @params taskId
     * @throws
     * @return boolean
     **/
    boolean remove(String taskId);

    /**
     * 关闭定时任务服务
     * @author Eric
     * @date 16:14 2019/3/12
     * @throws
     * @return void
     **/
    void shutdown();

    /**
     * 初始化定时任务服务
     * @author Eric
     * @date 16:15 2019/3/12
     * @throws
     * @return void
     **/
    void init() throws Exception;
}
