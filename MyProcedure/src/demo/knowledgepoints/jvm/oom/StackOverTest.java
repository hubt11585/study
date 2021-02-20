package demo.knowledgepoints.jvm.oom;

public class StackOverTest {

    private int val = 0;

    public void test(){
        val++;
        test();
    }

    public static void main(String[] args) {
        StackOverTest stackOverTest = new StackOverTest();
        try {
            stackOverTest.test();
        } catch (Throwable e) {
            System.out.println("’ª…Ó∂»£∫"+stackOverTest.val);
        }
    }
}
