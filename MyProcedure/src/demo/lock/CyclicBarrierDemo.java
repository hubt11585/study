package demo.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);   // ��Ҫ3���߳���ɲŻ��ͷ���Դ
        for (int i = 0; i < 6; i++) {
            int finalI = i;  // ��ֹ����������i��仯
            Thread thread = new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"��");
                try {
                    Thread.sleep(finalI *1000L);
                    cyclicBarrier.await();   // ÿ��ִ�� count ��һ��ֱ�����ٵ�0��await()�ͻ��ͷ���������ִ�С�
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("ִ��"+finalI+"ҵ���߼�����������");
            });
            thread.start();
        }
    }
}
