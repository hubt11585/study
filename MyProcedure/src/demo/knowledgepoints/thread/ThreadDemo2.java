package demo.knowledgepoints.thread;

public class ThreadDemo2 {

    private static int k = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000 ; i++) {
            Thread thread = new Thread(()->{
                k= k+1;
            });
            thread.start();
            thread.join();  //等待执行完成
        }
        System.out.println(k);
        System.out.println("运行："+(System.currentTimeMillis() - start)+"毫秒");
    }
}
