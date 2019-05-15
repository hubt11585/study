package demo.knowledgepoints.Unsafe;

import demo.knowledgepoints.BinarySystem;
import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class Momory {

    public static void main(String[] args) {

        /*
         * Unsafe的构造函数是私有的，不能通过new来获得实例。
         *
         *  通过反射来获取
         */
        Unsafe unsafe = null;
        Field field = null;
        try {
            field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            /*
             * private static final Unsafe theUnsafe = new Unsafe();
             *
             * 因为field的修饰符为 private static final,
             * 需要将setAccessible设置成true，否则会报java.lang.IllegalAccessException
             */
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String oneHundred = "fgh";

        String result = BinarySystem.toBinary(oneHundred);
        System.out.println(result);
        int size = 1024;

        /*
         * 调用allocateMemory分配内存
         */
        long memoryAddress = unsafe.allocateMemory(size);

        /*
         * 将100写入到内存中
         */
        unsafe.putAddress(memoryAddress, Long.parseLong(result));
        /*
         * 内存中读取数据
         */
        long readValue = unsafe.getAddress(memoryAddress);

        System.out.println("Val : " + readValue);
        System.out.println("memoryAddress : " + memoryAddress);
        unsafe.freeMemory(memoryAddress);
    }
}
