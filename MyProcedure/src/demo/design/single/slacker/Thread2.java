package demo.design.single.slacker;

public class Thread2 extends Thread {
    public void run() {
        System.out.println(SingletonSlacker.getInstance().hashCode());
    }
}
