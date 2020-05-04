package demo.knowledgepoints.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class CGLibTest {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "src\\demo\\knowledgepoints\\cglib");

        /**
         * 该类为CGLib设置动态代理的核心，你设置一个怎么样的动态代理
         */
        Enhancer enhancer = new Enhancer();
        /*******设置需要被代理的类**************/
        enhancer.setSuperclass(BaseDemo.class);
        /*******设置代理类**************/
        enhancer.setCallback(new MyMethodInterceptor());
        /*******创建代理类**************/
        BaseDemo proxyBaseDemo = (BaseDemo)enhancer.create();

        proxyBaseDemo.setName("李磊");

    }
}
