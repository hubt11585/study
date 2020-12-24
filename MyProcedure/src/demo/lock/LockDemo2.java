package demo.lock;

public class LockDemo2 {

    public static int a = 0;
    public static int b = 0;

    static A aa = new A();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true){
                synchronized (aa){
                    try {
                        if(b == 0){
                            b = 1;
                            a = 0;
                            System.out.println("发现B没有干活激活A,把锄头给B");
                        }else{
                            System.out.println("干活");
                        }
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (A.class) {
                    if (a == 0) {
                        a = 1;
                        b = 0;
                        System.out.println("发现A没有干活激活B,把锄头给A");
                    } else {
                        System.out.println("干活");
                    }
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
