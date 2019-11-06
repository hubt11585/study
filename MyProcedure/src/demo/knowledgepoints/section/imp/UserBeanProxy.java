package demo.knowledgepoints.section.imp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserBeanProxy implements InvocationHandler {

    private Object targetObject;

    public UserBeanProxy(Object targetObject)
    {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        UserBeanImpl userBean = (UserBeanImpl) targetObject;
        String flag = userBean.getFlag();
        Object result = null;

        //х╗очеп╤о
        if("1".equals(flag) ){
            result = method.invoke(targetObject, args);
        }else{
            System.out.println("sorry , You don't have permission");
        }
        return result;
    }
}
