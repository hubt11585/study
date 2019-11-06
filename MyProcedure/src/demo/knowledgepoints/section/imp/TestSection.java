package demo.knowledgepoints.section.imp;

import demo.knowledgepoints.section.inf.UserBean;

import java.lang.reflect.Proxy;

public class TestSection {
    public static void main(String[] args) {
        UserBeanImpl targetObject = new UserBeanImpl("蕾蕾","1");
        UserBeanProxy proxy = new UserBeanProxy(targetObject);
        //生成代理对象
        UserBean object = (UserBean) Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), proxy);

        String userName = object.getUser();
        System.out.println("userName: " + userName);
    }
}
