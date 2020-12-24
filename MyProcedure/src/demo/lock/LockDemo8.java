package demo.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class LockDemo8 extends Thread {

    private static int k = 0;
    static LockDemo8 lockDemo8 = new LockDemo8();


    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100 ; i++) {
            Thread thread = new LockDemo8();
            thread.start();
        }
        Thread.sleep(1000L);
        System.out.println(k);
    }

    @Override
    public void run() {
        add();
    }

    public static void add() {
        getUnSafe().monitorEnter(lockDemo8);
        for (int i = 0; i < 100 ; i++) {
            k++;
        }
        getUnSafe().monitorExit(lockDemo8);
    }

    public static Unsafe getUnSafe() {
        Unsafe unsafe = null;
        Field field = null;

        try {
            field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unsafe;
    }
}
