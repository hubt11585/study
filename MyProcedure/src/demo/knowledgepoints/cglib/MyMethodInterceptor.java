package demo.knowledgepoints.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("=============执行自己想要的内容start================");
        System.out.println("method.getName():" + method.getName());
        Object object = methodProxy.invokeSuper(o,objects);
        System.out.println("=============执行自己想要的内容end================");
        return object;
    }
}
