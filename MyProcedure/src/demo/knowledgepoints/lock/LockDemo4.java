package demo.knowledgepoints.lock;

import sun.misc.Contended;

public class LockDemo4 {

    public static class AA{
        @Contended
        volatile long i = 0;
        volatile long h = 0;
    }

    public static void main(String[] args) throws InterruptedException {
        test(new AA());
    }

    public static void test(AA aa) throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread thread1 = new Thread(()->{
            for(int i =0 ; i < 100000000 ; i++){
                aa.i++;
            }
        });

        Thread thread2 = new Thread(()->{
            for(int i =0 ; i < 100000000 ; i++){
                aa.h++;
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Ö´ÐÐ"+(System.currentTimeMillis() - start)+"ºÁÃë");
    }
}
