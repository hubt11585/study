package demo.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);   // 需要3个线程完成才会释放资源
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(()->{
                countDownLatch.countDown();   // 每次执行 count 减一，直到减少到0，await()就会释放正常网下执行。
                System.err.println(Thread.currentThread().getName()+"等");
            });
            thread.start();
        }

        try {
            countDownLatch.await();
            System.err.println("执行业务逻辑！！！！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
