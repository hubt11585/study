package demo.design.responsibility.imp;

import demo.design.responsibility.inf.Filter;

public class FaceFilter implements Filter {
    public void doFilter(Request request, Response response, FilterChain chain) {

        //���ַ����г��ֵ�":):"ת����"^V^";
        request.requestStr = request.requestStr.replace(":):", "^V^")
                //������ӵ��Ǳ������ǹ۲����ִ�в�����ַ���
                + "----FaceFilter()";
        chain.doFilter(request, response, chain);
        response.responseStr += "---FaceFilter()";
    }
}
