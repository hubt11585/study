package demo.design.responsibility.imp;

import demo.design.responsibility.inf.Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
    //��List�������洢���˹���
    List<Filter> filters = new ArrayList<Filter>();
    //���ڱ�ǹ��������˳��
    int index=0;
    //��������������ӹ���
    public FilterChain addFilter(Filter f) {
        filters.add(f);
        //�������Ƽ���:Chain����ӹ��˹�������󷵻���Ӻ��Chain��������������doFilter�����Ĳ���
        return this;
    }
    public void doFilter(Request request,Response response,FilterChain chain){
        //index��ʼ��Ϊ0,filters.size()Ϊ3������ִ��return����
        if(index==filters.size()){
            return;
        }
        //ÿ���һ�����˹���index����1
        Filter f=filters.get(index);
        index++;
        //��������ֵ��ȡ��Ӧ�Ĺ��ɹ�����ַ������д���
        f.doFilter(request, response, chain);
    }
}
