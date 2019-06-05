package demo.knowledgepoints.scheduledtask.iml;

import demo.knowledgepoints.scheduledtask.inf.TaskServcesInf;

public class TaskServcesIml implements TaskServcesInf {

    public void Test1(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1------------------------");
    }
    public void Test2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2------------------------");
    }

    public void Test3(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3------------------------");
    }
}
