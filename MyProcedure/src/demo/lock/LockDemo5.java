package demo.lock;

public class LockDemo5 {

    // volatile 能够防止指令重排序，防止对象在没有初始化完成之前，其他线程开始对其操作。
    private volatile static LockDemo5 lockDemo5;

    public static LockDemo5 getLockDemo5() {
        /**
         * 如果JVM对lockDemo5的对象创建进行了指令重新排序。
         * 在就是出现对象创建的第三步（指令初始化）还没有完成。
         * if(lockDemo5 == null){ 这个条件就会不满足，从而导致直接返回对象给外面使用。
         * 外面在使用的时候因为对象还没有初始化完成，就会出现未知错误。
         * volatile 可以防止指令重排序来解决这个问题。
         */
        if(lockDemo5 == null){
            synchronized (LockDemo5.class){
                if(lockDemo5 == null){
                    /**
                     * 创建对象分为三步
                     * 1. 开辟内存空间。
                     * 2. 初始化对象。
                     * 3. 引用变量执行内存地址。
                     *
                     * 因为初始化对象有时候会比较复杂，所以JVM会对其进行指令重排序
                     * 1. 开辟内存空间。
                     * 2. 引用变量执行内存地址。
                     * 3. 初始化对象。
                     *
                     */
                    lockDemo5 = new LockDemo5();
                }
            }
        }
        return lockDemo5;
    }

    public static void main(String[] args) {
        LockDemo5 lockDemo5 = getLockDemo5();
        System.out.println(lockDemo5);
    }
}
