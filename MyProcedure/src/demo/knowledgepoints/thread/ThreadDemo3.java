package demo.knowledgepoints.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadDemo3 {
    private static int k = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        // ExecutorService executorService = Executors.newSingleThreadExecutor(); // 单个线程
        // ExecutorService executorService = Executors.newFixedThreadPool(10); // 创建10个线程的缓存线程池
        ExecutorService executorService = Executors.newCachedThreadPool(); // 不够自动创建线程并且加入线程池

        for (int i = 0; i < 100000 ; i++) {
            executorService.execute(()->{
                k= k+1;
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(k);
        System.out.println("运行："+(System.currentTimeMillis() - start)+"毫秒");
    }
}
