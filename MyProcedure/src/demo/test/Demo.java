package demo.test;

public class Demo {
    private String name;
    private int age;

    public Demo(){
        /**
         * 构造方法中调用另一个构造方法，调用动作必须置于最起始位置。
         * 不能在构造方法之外调用构造方法。
         * 一个构造方法只能调用一个构造方法。
         */
        this("微学院",3);
    }

    public Demo(String name,int age){
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args){
        Demo demo = new Demo();
        //System.out.println(demo.name + "的年龄是" + demo.age);
        System.out.println("动物可以移动");
        System.out.println("狗可以跑和走");
    }
}
