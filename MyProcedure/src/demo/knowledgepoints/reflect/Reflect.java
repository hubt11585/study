package demo.knowledgepoints.reflect;

import java.lang.reflect.Field;

public class Reflect {
    public static void main(String[] args) {
        Demo1 demo1 = null;
        Demo2 demo2 = null;

        //Demo1 demo1 = new Demo1();
        //Demo2 demo2 = new Demo2();
        //发现new 类行不通。

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
        //发现get方法也获取不到，执行会报异常。

        //在这种情况下，我们还有一个方法:那就是通过反射来获取。
        //下面就是通过反射获取的方法。

        //首先通过Field，获取需要的类，Field包在jdk的反射包中：java.lang.reflect
        try {
            Field field1 = Demo1.class.getDeclaredField("demo1");
            //获取之后，强制转换成Demo1。
            demo1 =  (Demo1)field1.get(null);
            demo1.print();

            //然后我们再来创建一个Demo2.
            Field field2 = Demo2.class.getDeclaredField("demo2");
            //私有方法需要将：field2.setAccessible(true) ，才能获取到实例类
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
