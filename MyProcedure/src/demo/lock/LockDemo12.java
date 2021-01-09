package demo.lock;

public class LockDemo12 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(()->{
            while(true){
                System.out.println(Thread.currentThread().getName()+"begin wait");
                if(Thread.interrupted()){     // Thread.currentThread().isInterrupted()
                    break; // Java线程需要手工停止。
                }
            }

        });
        thread1.start();
        thread1.interrupt();  // 告知线程thread1可以停止了。
    }
}
