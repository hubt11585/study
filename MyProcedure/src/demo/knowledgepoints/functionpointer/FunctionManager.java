package demo.knowledgepoints.functionpointer;

public class FunctionManager {

    /**
     *  Զ�̵��÷���
     */
    public void remote(){
        Remote proxy = new Remote();
        proxy.service(this::callback);
    }

    /**
     * �ص�����
     * @param a
     * @param b
     */
    public void callback(String a,String b){
        System.out.println(a+"   "+ b);
    }
}
