package demo.knowledgepoints.reflect;

import java.lang.reflect.Field;

public class Reflect {
    public static void main(String[] args) {
        Demo1 demo1 = null;
        Demo2 demo2 = null;

        //Demo1 demo1 = new Demo1();
        //Demo2 demo2 = new Demo2();
        //����new ���в�ͨ��

        try {
            demo1 = Demo1.getDemo1();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            demo2 = Demo2.getDemo2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //����get����Ҳ��ȡ������ִ�лᱨ�쳣��

        //����������£����ǻ���һ������:�Ǿ���ͨ����������ȡ��
        //�������ͨ�������ȡ�ķ�����

        //����ͨ��Field����ȡ��Ҫ���࣬Field����jdk�ķ�����У�java.lang.reflect
        try {
            Field field1 = Demo1.class.getDeclaredField("demo1");
            //��ȡ֮��ǿ��ת����Demo1��
            demo1 =  (Demo1)field1.get(null);
            demo1.print();

            //Ȼ��������������һ��Demo2.
            Field field2 = Demo2.class.getDeclaredField("demo2");
            //˽�з�����Ҫ����field2.setAccessible(true) �����ܻ�ȡ��ʵ����
            field2.setAccessible(true);
            demo2 = (Demo2)field2.get(null);
            demo2.print();

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
