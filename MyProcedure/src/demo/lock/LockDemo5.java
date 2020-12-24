package demo.lock;

public class LockDemo5 {

    // volatile �ܹ���ָֹ�������򣬷�ֹ������û�г�ʼ�����֮ǰ�������߳̿�ʼ���������
    private volatile static LockDemo5 lockDemo5;

    public static LockDemo5 getLockDemo5() {
        /**
         * ���JVM��lockDemo5�Ķ��󴴽�������ָ����������
         * �ھ��ǳ��ֶ��󴴽��ĵ�������ָ���ʼ������û����ɡ�
         * if(lockDemo5 == null){ ��������ͻ᲻���㣬�Ӷ�����ֱ�ӷ��ض��������ʹ�á�
         * ������ʹ�õ�ʱ����Ϊ����û�г�ʼ����ɣ��ͻ����δ֪����
         * volatile ���Է�ָֹ�������������������⡣
         */
        if(lockDemo5 == null){
            synchronized (LockDemo5.class){
                if(lockDemo5 == null){
                    /**
                     * ���������Ϊ����
                     * 1. �����ڴ�ռ䡣
                     * 2. ��ʼ������
                     * 3. ���ñ���ִ���ڴ��ַ��
                     *
                     * ��Ϊ��ʼ��������ʱ���Ƚϸ��ӣ�����JVM��������ָ��������
                     * 1. �����ڴ�ռ䡣
                     * 2. ���ñ���ִ���ڴ��ַ��
                     * 3. ��ʼ������
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
