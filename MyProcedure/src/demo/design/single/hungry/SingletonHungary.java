package demo.design.single.hungry;

/********
 * �÷�ʽʵ�ֵ�����
 * �ŵ㣺����򵥣�������⡣
 * ȱ�㣺��Ϊ��̬����һ��ʼ��ռ�ڴ档
 */
public class SingletonHungary {
    private static SingletonHungary singletonHungary = new SingletonHungary();

    private SingletonHungary(){

    }

    public static SingletonHungary getInstance() {
        return singletonHungary;
    }
}
