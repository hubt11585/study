package demo.design.proxy.imp;

public class proxyTest {
    public static void main(String[] args) {
        Student Student = new Student();
        Teacher teacher = new Teacher(Student);
        teacher.eat();
    }
}
