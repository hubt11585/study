package demo.knowledgepoints.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadDemo3 {
    private static int k = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        // ExecutorService executorService = Executors.newSingleThreadExecutor(); // �����߳�
        // ExecutorService executorService = Executors.newFixedThreadPool(10); // ����10���̵߳Ļ����̳߳�
        ExecutorService executorService = Executors.newCachedThreadPool(); // �����Զ������̲߳��Ҽ����̳߳�

        for (int i = 0; i < 100000 ; i++) {
            executorService.execute(()->{
                k= k+1;
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(k);
        System.out.println("���У�"+(System.currentTimeMillis() - start)+"����");
    }
}
