package demo.test;

public class Dog{

    /**
     * ���ι��캯��
     * @param name
     * @param age
     */
    public Dog(String name,int age){
        this.age = age;
        this.name = name;
    }

    /**
     * �޲ҹ��캯��
     */
    public Dog(){}

    String name;
    int age;

    public void ptint(){
        System.out.println("name = "+this.name+";age = "+age);
    }

    public static void main(String[] args) {
        new Dog().ptint();
        new Dog("����",9).ptint();
    }
}