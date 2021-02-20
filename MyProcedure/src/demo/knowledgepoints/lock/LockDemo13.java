package demo.knowledgepoints.lock;

public class LockDemo13 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(()->{
            while(true){
                System.out.println(Thread.currentThread().getName()+"begin wait");

                try {
                    Thread.sleep(5000L);    // 特别注意点Sleep可以感知中断标记，并且清楚中断标记导致后面获取不到中断标记
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(Thread.interrupted()){     // Thread.currentThread().isInterrupted()
                    break; // Java线程需要手工停止。
                }
            }

        });
        thread1.start();
        thread1.interrupt();  // 告知线程thread1可以停止了。
    }
}
