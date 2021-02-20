package demo.knowledgepoints.lock;

import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.LockSupport;

public class ABALockDemo1 {
    static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1,1);

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            int[] stampHolder = new int[1];
            int var = (Integer) atomicStampedReference.get(stampHolder);
            int stamp = stampHolder[0];
            LockSupport.parkNanos(1000000000L);
            if (atomicStampedReference.compareAndSet(var,3,stamp,stamp+1)) {
                System.out.println("从"+var+"改成3");
            }else{
                System.out.println("fail");
            }
        });

        Thread thread2 = new Thread(()->{
            int[] stampHolder = new int[1];
            int var = (Integer) atomicStampedReference.get(stampHolder);
            int stamp = stampHolder[0];
            if (atomicStampedReference.compareAndSet(var,2,stamp,stamp+1)) {
                System.out.println("从"+var+"改成2");
            }else{
                System.out.println("fail");
            }

            var = (Integer) atomicStampedReference.get(stampHolder);
            stamp = stampHolder[0];
            if (atomicStampedReference.compareAndSet(var,1,stamp,stamp+1)) {
                System.out.println("从"+var+"改成1");
            }else{
                System.out.println("fail");
            }
        });

        thread1.start();
        thread2.start();
    }
}
