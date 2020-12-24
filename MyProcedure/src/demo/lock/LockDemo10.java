package demo.lock;

public class LockDemo10 {

    static Object object = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(()->{
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"begin wait");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"end wait");
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"begin notify");
                try {
                    Thread.sleep(2000L);
                    object.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"end notify");
            }
        });

        thread1.start();
        thread2.start();
    }
}
