package demo.knowledgepoints.jvm;

public class JvmTest2 {

    public static void main(String[] args) {
        System.out.println(B.str);
    }
}

class A {
    static String str = "a";
    static {
        System.out.println("static a");
    }
}

class B extends A {
    static {
        System.out.println("static b");
    }
}
