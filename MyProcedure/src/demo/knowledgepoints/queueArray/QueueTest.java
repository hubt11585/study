package demo.knowledgepoints.queueArray;

import java.util.concurrent.ArrayBlockingQueue;

public class QueueTest {
    static ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(100000);


    public static void main(String[] args) {
        Runnable runnable0 = () -> {
            int i = 0;
            while(true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("add:"+i);
                arrayBlockingQueue.add(i++);
            }
        };

        Runnable runnable1 = () -> {
            int i = 0;
            while(true){
                try {
                    Thread.sleep(200);
                    System.out.println("remove:"+arrayBlockingQueue.remove());
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
