package demo.knowledgepoints.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadDemo4 {
    private static int k = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,20,10l,TimeUnit.DAYS,new ArrayBlockingQueue<>(10));

        for (int i = 0; i < 100 ; i++) {
            threadPoolExecutor.execute(()->{
                k= k+1;
                System.out.println(k);
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(k);
        System.out.println("‘À––£∫"+(System.currentTimeMillis() - start)+"∫¡√Î");
    }
}
