package demo.design.responsibility.imp;

import demo.design.responsibility.inf.Filter;

public class HTMLFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        //���ַ����г��ֵ�"<>"�����滻��"[]"
        request.requestStr=request.requestStr
                .replace('<', '[').replace('>', ']')+
                //������ӵ��Ǳ������ǹ۲����ִ�в�����ַ���
                "----HTMLFilter()";
        chain.doFilter(request, response,chain);
        response.responseStr+="---HTMLFilter()";
    }
}
