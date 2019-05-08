package demo.knowledgepoints.section.imp;

import demo.knowledgepoints.section.inf.UserBean;

import java.lang.reflect.Proxy;

public class TestSection {
    public static void main(String[] args) {
        System.out.println("使用代理。。。。。。");
        UserBeanImpl targetObject = new UserBeanImpl("dd");
        UserBeanProxy proxy = new UserBeanProxy(targetObject);
        //生成代理对象
        UserBean object = (UserBean) Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), proxy);

        object.addUser();
        object.getUser();

        System.out.println("不使用代理。。。。。。");
        targetObject = new UserBeanImpl("ee");
        targetObject.addUser();
        targetObject.getUser();
    }
}
