package demo.test;

public class Outer {
    public static final int TOTAL_NUMBER = 5;
    public int id = 123;
    public void func() {
        final int age = 15;
        String str = "http://www.weixueyuan.net";
        class Inner {
            public void innerTest() {
                System.out.println(TOTAL_NUMBER);
                System.out.println(id);
                // System.out.println(str);���Ϸ���ֻ�ܷ��ʱ��ط�����final����
                System.out.println(age);
            }
        }
        new Inner().innerTest();
    }
    public static void main(String[] args) {
        System.out.println("eat something");
    }
}
