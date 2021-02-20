package demo.knowledgepoints.lock;

public class LockDemo3 {

    private static boolean status = false;

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            int i = 0;
            while (!status) {
                i++;
                // û�м��κ��������벻������ѭ����

                // ������ѭ��(println �����Դ�synchronized)
                // System.out.println("���i="+i);

                // ��������ѭ����û�е�����ʧЧʱ�䣩
                // shortWait(1000);

                // ������ѭ����������ʧЧʱ�䣩
                // shortWait(10000);

                // ������ѭ������Ϊsleep���ó�ʱ��Ƭ�������߳����»�ȡʱ��Ƭ�������¶�ȡ��������ݣ�
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("����ѭ��");
        }).start();

        Thread.sleep(1000L);
        status = true;
        System.out.println("status is " + status);
    }

    public static void shortWait(long interval){
        long start = System.nanoTime();
        long end;
        do{
            end = System.nanoTime();
        }while(start + interval >= end);
    }
}
