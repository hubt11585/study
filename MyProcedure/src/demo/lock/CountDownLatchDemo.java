package demo.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);   // ��Ҫ3���߳���ɲŻ��ͷ���Դ
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(()->{
                countDownLatch.countDown();   // ÿ��ִ�� count ��һ��ֱ�����ٵ�0��await()�ͻ��ͷ���������ִ�С�
                System.err.println(Thread.currentThread().getName()+"��");
            });
            thread.start();
        }

        try {
            countDownLatch.await();
            System.err.println("ִ��ҵ���߼�����������");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
