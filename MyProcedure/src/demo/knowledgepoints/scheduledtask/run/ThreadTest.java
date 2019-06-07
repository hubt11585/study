package demo.knowledgepoints.scheduledtask.run;

/***
 * 线程类
 */
public class ThreadTest implements Runnable {

    public static int ticket = 9;

    @Override
    public void run() {
        try {
            System.out.println("当前线程："+Thread.currentThread().getName());
            while(true){
                synchronized (this) {
                    Thread.sleep(1000L);
                    if (this.ticket > 0) {
                        ticket--;
                        System.out.println(Thread.currentThread().getName() + ":出售一张票！");
                        System.out.println("剩余票量：" + ticket);
                    } else {
                        System.out.println("没有票了！");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
