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
        String userName = userBean.getUserName();
        Object result = null;

        //х╗очеп╤о
        if("ee".equals(userName) )
        {
            result = method.invoke(targetObject, args);
        }

        return result;
    }
}
