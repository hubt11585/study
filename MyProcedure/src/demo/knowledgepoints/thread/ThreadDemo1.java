package demo.knowledgepoints.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "ÄãºÃ";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new ThreadDemo1()) ;
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
