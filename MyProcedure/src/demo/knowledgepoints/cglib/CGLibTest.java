package demo.knowledgepoints.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class CGLibTest {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "src\\demo\\knowledgepoints\\cglib");

        /**
         * ����ΪCGLib���ö�̬����ĺ��ģ�������һ����ô���Ķ�̬����
         */
        Enhancer enhancer = new Enhancer();
        /*******������Ҫ���������**************/
        enhancer.setSuperclass(BaseDemo.class);
        /*******���ô�����**************/
        enhancer.setCallback(new MyMethodInterceptor());
        /*******����������**************/
        BaseDemo proxyBaseDemo = (BaseDemo)enhancer.create();

        proxyBaseDemo.setName("����");

    }
}
