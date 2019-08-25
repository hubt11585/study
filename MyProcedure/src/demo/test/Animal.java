package demo.test;

public abstract class Animal {
    void eat() {
        System.out.println("动物爱吃饭");
    }
    //抽象方法在抽象类中只能声明，不能具体实现
    abstract void breath();
    void sleep() {
        System.out.println("动物在睡觉");
    }
}
