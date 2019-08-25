package demo.test;

public class Demo {

    public void test1(A a) {
        a.doSth();
    }
    public static void main(String[] args) {
        Demo d = new Demo();
        A a = new B();
        d.test1(a);
    }
}