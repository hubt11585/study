package demo.knowledgepoints.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreLockDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);   // ������������
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                try {
                    semaphore.acquire();   // ռ�ô���
                    System.out.println(Thread.currentThread().getName()+"��ʼ��Ʊ");
                    Thread.sleep(5000L);  // ����5���Ӵ�����Ʊ���顣
                    System.out.println(Thread.currentThread().getName()+"��Ʊ�ɹ�����һλ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();  // �ͷŴ���
                }

            });
            thread.start();
        }
    }
}
