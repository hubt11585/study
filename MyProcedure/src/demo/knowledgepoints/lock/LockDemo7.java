package demo.knowledgepoints.lock;

public class LockDemo7 extends Thread {

    private static int k = 0;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100 ; i++) {
            Thread thread = new LockDemo7();
            thread.start();
        }
        Thread.sleep(1000L);
        System.out.println(k);
    }

    @Override
    public void run() {
        add();
    }

    public synchronized static void add() {
        for (int i = 0; i < 100 ; i++) {
            k++;
        }
    }
}
