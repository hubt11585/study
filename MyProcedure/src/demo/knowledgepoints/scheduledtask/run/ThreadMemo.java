package demo.knowledgepoints.scheduledtask.run;

public class ThreadMemo {
    public static void main(String[] args) {
        ThreadTest threadTest1 =new ThreadTest();
        new Thread(threadTest1).start();
        new Thread(threadTest1).start();
    }
}
