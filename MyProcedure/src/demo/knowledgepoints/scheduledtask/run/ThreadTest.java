package demo.knowledgepoints.scheduledtask.run;

/***
 * �߳���
 */
public class ThreadTest implements Runnable {

    public static int ticket = 9;

    @Override
    public void run() {
        try {
            System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName());
            while(true){
                synchronized (this) {
                    Thread.sleep(1000L);
                    if (this.ticket > 0) {
                        ticket--;
                        System.out.println(Thread.currentThread().getName() + ":����һ��Ʊ��");
                        System.out.println("ʣ��Ʊ����" + ticket);
                    } else {
                        System.out.println("û��Ʊ�ˣ�");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
