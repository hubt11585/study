package demo.knowledgepoints.reflect;

public class Demo1 {
    //����һ���Լ�����Ĺ�������
    public static demo.knowledgepoints.reflect.Demo1 demo1;

    private static final boolean flag = true ;

    //����˽�л�����֤����ͨ��New�ķ�ʽ������
    private Demo1(){

    }

    //����get���������ڸ�֪ʹ���ߣ����ܱ�new�����ܱ���ȡ��
    public static Demo1 getDemo1() throws Exception{
        if(flag){
            throw new Exception("��Ǹ,���಻ͨ��new �ķ�ʽ������");
        }
        return demo1;
    }

    public void print(){
        System.out.println("��ϲ�ɹ���ȡDemo1��");
    }

    //ͨ����̬����鴴��ʵ���ࡣ
    static {
        demo1 = new Demo1();
    }
}
