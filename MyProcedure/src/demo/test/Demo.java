package demo.test;

public class Demo {
    private String name;
    private int age;

    public Demo(){
        /**
         * ���췽���е�����һ�����췽�������ö���������������ʼλ�á�
         * �����ڹ��췽��֮����ù��췽����
         * һ�����췽��ֻ�ܵ���һ�����췽����
         */
        this("΢ѧԺ",3);
    }

    public Demo(String name,int age){
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args){
        Demo demo = new Demo();
        //System.out.println(demo.name + "��������" + demo.age);
        System.out.println("��������ƶ�");
        System.out.println("�������ܺ���");
    }
}
