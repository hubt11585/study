package demo.knowledgepoints.Unsafe;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class Momory {

    public static void main(String[] args) {

        /*
         * Unsafe�Ĺ��캯����˽�еģ�����ͨ��new�����ʵ����
         *
         *  ͨ����������ȡ
         */
        Unsafe unsafe = null;
        Field field = null;
        try {
            field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
            /*
             * private static final Unsafe theUnsafe = new Unsafe();
             *
             * ��Ϊfield�����η�Ϊ private static final,
             * ��Ҫ��setAccessible���ó�true������ᱨjava.lang.IllegalAccessException
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

        long oneHundred = 100;
        long twoHundred = 10;
        byte size = 1;

        /*
         * ����allocateMemory�����ڴ�
         */
        long memoryAddress = unsafe.allocateMemory(size);

        /*
         * ��100д�뵽�ڴ���
         */
        unsafe.putAddress(memoryAddress, oneHundred);
        unsafe.putAddress(470446864, twoHundred);
        /*
         * �ڴ��ж�ȡ����
         */
        long readValue = unsafe.getAddress(470446864);

        System.out.println("Val : " + readValue);
        System.out.println("memoryAddress : " + memoryAddress);
    }
}
