package demo.test;

public class Demo {
    private String name;
    private int age;

    public Demo(){
        name = "微学院";
        age = 3;
    }
    public static void main(String[] args){
        Demo demo = new Demo();
        System.out.println(demo.name + "的年龄是" + demo.age);
    }
}
