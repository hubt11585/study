package demo.knowledgepoints.reflect;

public class Demo2 {
    //����һ���Լ������˽�б���
    private static demo.knowledgepoints.reflect.Demo2 demo2;

    private static final boolean flag = true ;

    //����˽�л�����֤����ͨ��New�ķ�ʽ������
    private Demo2(){}

    //����get���������ڸ�֪ʹ���ߣ����ܱ�new�����ܱ���ȡ��
    public static Demo2 getDemo2() throws Exception{
        if(flag){
            throw new Exception("��Ǹ,���಻ͨ��new �ķ�ʽ������");
        }
        return demo2;
    }

    public void print(){
        System.out.println("��ϲ�ɹ���ȡDemo2��");
    }

    //ͨ����̬����鴴��ʵ���ࡣ
    static {
        demo2 = new Demo2();
    }
}
