package demo.knowledgepoints.jvm;

public class JvmTest1 {

    public static void main(String[] args) {
        Test1 test1 = Test1.getTest();
        System.out.println(Test1.val1);
        System.out.println(Test1.val2);
    }
}

class Test1{
    public static int val1 ;

    Test1(){
        val1++;
        val2++;
    }

    public static Test1 instance = new Test1();

    public static int val2 = 1 ;    // 该代码放在在初始化代码

    public static Test1 getTest(){
        return instance;
    }
}
