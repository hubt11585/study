package demo.test;

public class Dog
{
    String name;
    int age;

    Dog(String name1,int age1)
    {
        name = name1;
        age = age1;
        System.out.println("��л������������");
    }

    void bark()
    {
        System.out.println("��������Ҫ����");
    }

    void hungry()
    {
        System.out.println("���ˣ��Ҷ���");
    }

    public static void main(String[] args)
    {
        Dog myDog = new Dog("����",3);
        //���ʳ�Ա����
        String name = myDog.name;
        int age = myDog.age;
        System.out.println("����һֻС���������ֽ�" + name + ",��" + age + "����");
        //���ʷ���
        myDog.bark();
        myDog.hungry();
    }
}
