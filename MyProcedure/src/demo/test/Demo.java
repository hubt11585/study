package demo.test;

public class Demo {
    private String name;
    private int age;

    public Demo(){
        name = "΢ѧԺ";
        age = 3;
    }
    public static void main(String[] args){
        Demo demo = new Demo();
        System.out.println(demo.name + "��������" + demo.age);
    }
}
