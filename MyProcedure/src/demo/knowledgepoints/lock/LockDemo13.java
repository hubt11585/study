package demo.knowledgepoints.lock;

public class LockDemo13 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(()->{
            while(true){
                System.out.println(Thread.currentThread().getName()+"begin wait");

                try {
                    Thread.sleep(5000L);    // �ر�ע���Sleep���Ը�֪�жϱ�ǣ���������жϱ�ǵ��º����ȡ�����жϱ��
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(Thread.interrupted()){     // Thread.currentThread().isInterrupted()
                    break; // Java�߳���Ҫ�ֹ�ֹͣ��
                }
            }

        });
        thread1.start();
        thread1.interrupt();  // ��֪�߳�thread1����ֹͣ�ˡ�
    }
}
