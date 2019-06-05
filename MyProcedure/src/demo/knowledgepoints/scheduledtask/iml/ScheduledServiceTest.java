package demo.knowledgepoints.scheduledtask.iml;

import demo.knowledgepoints.scheduledtask.inf.TaskServcesInf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ScheduledServiceTest {

    public static void main(String[] args) {

        /*Class<?> cls = null;
        try {
            cls = Class.forName("demo.knowledgepoints.scheduledtask.iml.TaskServcesIml");

            TaskServcesIml taskServcesIml = (TaskServcesIml) cls.newInstance();
            taskServcesIml.Test1();


        Method getMoney = cls.getMethod("Test1");//得到方法对象
            getMoney.invoke(cls.newInstance(),null);
        getMoney.invoke(cls);//调用借钱方法，得到返回值


        } catch (Exception e) {
            e.printStackTrace();
        }*/
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
