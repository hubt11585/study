package demo.knowledgepoints.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ABALockDemo {
    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            int var = atomicInteger.get();
            LockSupport.parkNanos(1000000000L);
            if (atomicInteger.compareAndSet(var,3)) {
                System.out.println("��"+var+"�ĳ�3");
            }else{
                System.out.println("fail");
            }
        });

        Thread thread2 = new Thread(()->{
            int var = atomicInteger.get();

            if (atomicInteger.compareAndSet(var,2)) {
                System.out.println("��"+var+"�ĳ�2");
            }else{
                System.out.println("fail");
            }

            var = atomicInteger.get();
            if (atomicInteger.compareAndSet(var,1)) {
                System.out.println("��"+var+"�ĳ�1");
            }else{
                System.out.println("fail");
            }
        });

        thread1.start();
        thread2.start();
    }
}
