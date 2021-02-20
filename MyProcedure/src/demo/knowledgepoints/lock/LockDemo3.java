package demo.knowledgepoints.lock;

public class LockDemo3 {

    private static boolean status = false;

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            int i = 0;
            while (!status) {
                i++;
                // 没有加任何其他代码不能跳出循环。

                // 能跳出循环(println 方法自带synchronized)
                // System.out.println("输出i="+i);

                // 不能跳出循环（没有到缓存失效时间）
                // shortWait(1000);

                // 能跳出循环（到缓存失效时间）
                // shortWait(10000);

                // 能跳出循环（因为sleep会让出时间片，后面线程重新获取时间片，会重新读取主存的数据）
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("跳出循环");
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
