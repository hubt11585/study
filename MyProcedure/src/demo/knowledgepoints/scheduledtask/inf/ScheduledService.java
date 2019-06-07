package demo.knowledgepoints.scheduledtask.inf;

import demo.knowledgepoints.scheduledtask.iml.ScheduledTaskTot;

public interface ScheduledService {

    /**
     * ���һ������
     * @author Eric
     * @date 16:14 2019/3/12
     * @params runnable
     * @params taskId
     * @params initialDelay ���εȴ� ����
     * @params delay ���ʱ�� ���루���ӳ٣�
     * @throws
     * @return boolean
     **/
    boolean addFixedTask(ScheduledTaskTot scheduledTaskTot);

    /**
     * ���һ������
     * @author Eric
     * @date 16:14 2019/3/12
     * @params runnable
     * @params taskId
     * @params initialDelay ���εȴ� ����
     * @params delay ���ʱ�� ���루�ӳ٣�
     * @throws
     * @return boolean
     **/
    boolean addTask(ScheduledTaskTot scheduledTaskTot);

    /**
     * �޸�һ������
     * @author Eric
     * @date 16:14 2019/3/12
     * @params runnable
     * @params taskId
     * @params initialDelay ���εȴ� ����
     * @params delay ���ʱ�� ����
     * @throws
     * @return boolean
     **/
    boolean updateTask(ScheduledTaskTot scheduledTaskTot) throws InterruptedException;

    /**
     * �Ƴ�һ������
     * @author Eric
     * @date 16:14 2019/3/12
     * @params taskId
     * @throws
     * @return boolean
     **/
    boolean remove(String taskId);

    /**
     * �رն�ʱ�������
     * @author Eric
     * @date 16:14 2019/3/12
     * @throws
     * @return void
     **/
    void shutdown();

    /**
     * ��ʼ����ʱ�������
     * @author Eric
     * @date 16:15 2019/3/12
     * @throws
     * @return void
     **/
    void init() throws Exception;
}
