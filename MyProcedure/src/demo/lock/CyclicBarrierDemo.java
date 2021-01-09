package demo.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);   // 需要3个线程完成才会释放资源
        for (int i = 0; i < 6; i++) {
            int finalI = i;  // 防止操作过程中i会变化
            Thread thread = new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"等");
                try {
                    Thread.sleep(finalI *1000L);
                    cyclicBarrier.await();   // 每次执行 count 减一，直到减少到0，await()就会释放正常网下执行。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("执行"+finalI+"业务逻辑！！！！！");
            });
            thread.start();
        }
    }
}
