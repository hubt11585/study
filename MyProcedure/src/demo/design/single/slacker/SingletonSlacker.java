package demo.design.single.slacker;

public class SingletonSlacker {

    private static SingletonSlacker singletonSlacker = null;
    //˽�л����캯�������ó�ʼ��
    private SingletonSlacker(){

    }

    public static synchronized SingletonSlacker getInstance() {

        if(singletonSlacker == null){
            singletonSlacker = new SingletonSlacker();
        }
        return singletonSlacker;
    }


}
