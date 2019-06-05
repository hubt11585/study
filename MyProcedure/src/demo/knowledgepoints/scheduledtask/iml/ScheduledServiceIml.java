package demo.knowledgepoints.scheduledtask.iml;

import demo.knowledgepoints.scheduledtask.inf.ScheduledService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledServiceIml implements ScheduledService {

    private static ScheduledExecutorService service;


    private static Map<String, ScheduledFuture> futureMap = new ConcurrentHashMap<>();

    @Override
    public boolean addFixedTask(ScheduledTaskTot scheduledTaskTot) {
        if (futureMap.get(scheduledTaskTot.getTaskId()) != null) {
            return false;
        }
        // 这里将任务放入定时服务中
        ScheduledFuture<?> scheduledFuture = service.scheduleAtFixedRate(scheduledTaskTot.getRunnable()
                , scheduledTaskTot.getInitialDelay(), scheduledTaskTot.getDelay(), TimeUnit.MILLISECONDS);

        futureMap.put(scheduledTaskTot.getTaskId(),scheduledFuture);
        return true;
    }

    @Override
    public boolean addTask(ScheduledTaskTot scheduledTaskTot) {
        if (futureMap.get(scheduledTaskTot.getTaskId()) != null) {
            return false;
        }
        // 这里将任务放入定时服务中
        ScheduledFuture<?> scheduledFuture = service.scheduleWithFixedDelay(scheduledTaskTot.getRunnable()
                , scheduledTaskTot.getInitialDelay(), scheduledTaskTot.getDelay(), TimeUnit.MILLISECONDS);

        futureMap.put(scheduledTaskTot.getTaskId(),scheduledFuture);

        return true;
    }

    @Override
    public boolean updateTask(ScheduledTaskTot scheduledTaskTot) throws InterruptedException {
        if (futureMap.get(scheduledTaskTot.getTaskId()) == null) {
            return false;
        }
        // 先停止
        remove(scheduledTaskTot.getTaskId());

        // 再添加
        addTask(scheduledTaskTot);
        return true;
    }

    @Override
    public boolean remove(String taskId) {
        if (futureMap.get(taskId) == null) {
            return false;
        }
        ScheduledFuture scheduledFuture = futureMap.get(taskId);
        scheduledFuture.cancel(false);
        futureMap.remove(taskId);
        return true;
    }

    @Override
    public void shutdown() {
        service.shutdown();
    }

    @Override
    public void init() throws Exception {
        service = Executors.newScheduledThreadPool(8);
    }
}
