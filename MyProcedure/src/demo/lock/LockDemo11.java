package demo.lock;

import java.util.concurrent.locks.LockSupport;

public class LockDemo11 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"begin wait");
            LockSupport.park();    // 进行许可认证。
            System.out.println(Thread.currentThread().getName()+"end wait");

        });

        Thread thread2 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"begin notify");
            System.out.println(Thread.currentThread().getName()+"end notify");
        });

        thread1.start();
        thread2.start();

        thread2.join();  //等待线程2执行完毕。

        LockSupport.unpark(thread1); // 发放许可证。
    }
}
