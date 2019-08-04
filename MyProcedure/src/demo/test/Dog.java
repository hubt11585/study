package demo.test;

public class Dog{

    /**
     * 带参构造函数
     * @param name
     * @param age
     */
    public Dog(String name,int age){
        this.age = age;
        this.name = name;
    }

    /**
     * 无惨构造函数
     */
    public Dog(){}

    String name;
    int age;

    public void ptint(){
        System.out.println("name = "+this.name+";age = "+age);
    }

    public static void main(String[] args) {
        new Dog().ptint();
        new Dog("花花",9).ptint();
    }
}