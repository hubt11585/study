package demo.knowledgepoints.scheduledtask.iml;

public class ScheduledServiceTest {

    public static void main(String[] args) {
        ScheduledServiceIml scheduledServiceIml = new ScheduledServiceIml();
        try {
            scheduledServiceIml.init();
            scheduledServiceIml.addTask(new ScheduledTaskTot("T0001","demo.knowledgepoints.scheduledtask.iml.TaskServcesIml","Test1",1000L,5000L,null,null));
            scheduledServiceIml.addTask(new ScheduledTaskTot("T0002","demo.knowledgepoints.scheduledtask.iml.TaskServcesIml","Test2",1000L,5000L,null,null));
            scheduledServiceIml.addTask(new ScheduledTaskTot("T0003","demo.knowledgepoints.scheduledtask.iml.TaskServcesIml","Test3",1000L,5000L,null,null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
