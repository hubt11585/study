package demo.knowledgepoints.queueArray;

import java.util.concurrent.SynchronousQueue;

public class SynQueueTest {

    static SynchronousQueue synchronousQueue = new SynchronousQueue();


    public static void main(String[] args) {
        Runnable runnable0 = () -> {
            while(true){
                try {
                    Thread.sleep(100);
                    System.out.println("add");
                    synchronousQueue.put("add");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable runnable1 = () -> {
            int i = 0;
            while(true){
                try {
                    Thread.sleep(200);
                    System.out.println("take"+synchronousQueue.take());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread0 = new Thread(runnable0);
        Thread thread1 = new Thread(runnable1);
        thread0.start();
        thread1.start();
    }
}
