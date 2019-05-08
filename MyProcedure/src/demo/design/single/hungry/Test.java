package demo.design.single.hungry;

public class Test {
    public static void main(String[] args){
        SingletonHungary singletonHungary1 = SingletonHungary.getInstance();
        System.out.println(singletonHungary1.getInstance().hashCode());
        SingletonHungary singletonHungary2 = SingletonHungary.getInstance();
        System.out.println(singletonHungary2.getInstance().hashCode());
        SingletonHungary singletonHungary3 = SingletonHungary.getInstance();
        System.out.println(singletonHungary3.getInstance().hashCode());
        SingletonHungary singletonHungary4 = SingletonHungary.getInstance();
        System.out.println(singletonHungary4.getInstance().hashCode());
        SingletonHungary singletonHungary5 = SingletonHungary.getInstance();
        System.out.println(singletonHungary5.getInstance().hashCode());
        SingletonHungary singletonHungary6 = SingletonHungary.getInstance();
        System.out.println(singletonHungary6.getInstance().hashCode());
        SingletonHungary singletonHungary7 = SingletonHungary.getInstance();
        System.out.println(singletonHungary7.getInstance().hashCode());
        SingletonHungary singletonHungary8 = SingletonHungary.getInstance();
        System.out.println(singletonHungary8.getInstance().hashCode());
        SingletonHungary singletonHungary9 = SingletonHungary.getInstance();
        System.out.println(singletonHungary9.getInstance().hashCode());
    }
}
