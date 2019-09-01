package demo.knowledgepoints.scheduledtask.Thread;

public class Thread1 extends Thread {

    public static int ticket = 5;

    @Override
    public void run() {
        try {
            System.out.println("当前线程："+Thread.currentThread().getName());
            while(true){
                synchronized (this) {
                    Thread.sleep(2000L);
                    if (this.ticket > 0) {
                        ticket--;
                        System.out.println(Thread.currentThread().getName() + ":出售一张票！"+"剩余票量：" + ticket);
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
