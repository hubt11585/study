package demo.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static int k = 0;

    public static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        for (int j = 0;  j< 3; j++) {
            Thread thread = new Thread(()->{
                reentrantLock.lock(); // 加锁
                try {
                    for (int i = 0; i < 100; i++) {
                        k++;
                    }
                    System.out.println("k="+k);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();   // 显示锁，解锁必须放入finally中执行。
                }
            });
            thread.start();
        }
    }
}
