package demo.knowledgepoints.scheduledtask.Thread;

public class Thread1 extends Thread {

    public static int ticket = 5;

    @Override
    public void run() {
        try {
            System.out.println("��ǰ�̣߳�"+Thread.currentThread().getName());
            while(true){
                synchronized (this) {
                    Thread.sleep(2000L);
                    if (this.ticket > 0) {
                        ticket--;
                        System.out.println(Thread.currentThread().getName() + ":����һ��Ʊ��"+"ʣ��Ʊ����" + ticket);
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
