package demo.knowledgepoints.Lambda.inf;

@FunctionalInterface
public interface MyLamda {
    public void test1(String y);

//�������������һ�����󷽷���ᱨ��
//    public void test1();

    //default�����������ⶨ��
    default String test2(){
        return "123";
    }

    default String test3(){
        return "123";
    }

    //static����Ҳ���Զ���
    static void test4(){
        System.out.println("234");
    }
}
