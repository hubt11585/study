package demo.design.single.slacker;

public class SingletonSlacker {

    private static SingletonSlacker singletonSlacker = null;
    //私有化构造函数，不让初始化
    private SingletonSlacker(){

    }

    public static synchronized SingletonSlacker getInstance() {

        if(singletonSlacker == null){
            singletonSlacker = new SingletonSlacker();
        }
        return singletonSlacker;
    }


}
