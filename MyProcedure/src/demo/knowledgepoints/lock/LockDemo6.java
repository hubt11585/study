package demo.knowledgepoints.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class LockDemo6 {

    private static int x,y = 0;
    private static int a,b = 0;

    public static void main(String[] args) throws InterruptedException {
        while(true){
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread thread1 = new Thread(()->{
                shortWait(20000L);
                a = 1;
                // ÄÚ´æÆÁÕÏ
                //getUnSafe().storeFence();
                x = b;
            });

            Thread thread2 = new Thread(()->{
                b = 1;
                //getUnSafe().storeFence();
                y = a;
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            System.out.println("x="+x+";y="+y);
            if(x==0 && y==0){
                break;
            }
        }
    }

    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
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
