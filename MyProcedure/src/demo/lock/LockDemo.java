package demo.lock;

public class LockDemo {

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (A.class){
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B.class) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("线程1");
                    }
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (B.class){
                synchronized (A.class) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("线程2");
                    }
                }
            }
        }).start();
    }
}
