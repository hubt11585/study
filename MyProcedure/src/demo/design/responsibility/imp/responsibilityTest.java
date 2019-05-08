package demo.design.responsibility.imp;

public class responsibilityTest {
    public static void main(String args[]) {
        //�趨���˹��򣬶�msg�ַ������й��˴���
        String msg = ":):,<script>,����,����ҵ,�����ڿ�";
        System.out.println(msg);
        //��������
        Request request=new Request();
        //set���������������ַ������ݽ�ȥ
        request.setRequestStr(msg);
        //������̽�������������Ӧ
        Response response=new Response();
        //������Ӧ��Ϣ
        response.setResponseStr("response:");
        //FilterChain,���˹����γɵ���������
        FilterChain fc=new FilterChain();
        //����������ӹ��˹��򣬲��õ�����ʽ����
        fc.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter())
                .addFilter(new FaceFilter());
        //����FilterChain�Ĺ���˳������Ӧ�ù��˹���
        fc.doFilter(request, response,fc);
        //��ӡ������Ϣ
        System.out.println(request.getRequestStr());
        //��ӡ��Ӧ��Ϣ
        System.out.println(response.getResponseStr());
    }
}
