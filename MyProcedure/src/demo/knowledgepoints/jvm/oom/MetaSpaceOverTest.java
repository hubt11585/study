package demo.knowledgepoints.jvm.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MetaSpaceOverTest {

    public static void main(String[] args) throws InterruptedException {
        while (true){
            Thread.sleep(20);

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MetaSpaceOverTest.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o,objects);
                }
            });
            enhancer.create();
        }
    }
}
