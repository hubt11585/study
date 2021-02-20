package demo.knowledgepoints.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreLockDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);   // 创建三个窗口
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                try {
                    semaphore.acquire();   // 占用窗口
                    System.out.println(Thread.currentThread().getName()+"开始买票");
                    Thread.sleep(5000L);  // 花费5秒钟处理买票事情。
                    System.out.println(Thread.currentThread().getName()+"买票成功，下一位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();  // 释放窗口
                }

            });
            thread.start();
        }
    }
}
