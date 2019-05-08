package demo.knowledgepoints.section.imp;

import demo.knowledgepoints.section.inf.UserBean;

import java.lang.reflect.Proxy;

public class TestSection {
    public static void main(String[] args) {
        System.out.println("ʹ�ô�������������");
        UserBeanImpl targetObject = new UserBeanImpl("dd");
        UserBeanProxy proxy = new UserBeanProxy(targetObject);
        //���ɴ������
        UserBean object = (UserBean) Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), proxy);

        object.addUser();
        object.getUser();

        System.out.println("��ʹ�ô�������������");
        targetObject = new UserBeanImpl("ee");
        targetObject.addUser();
        targetObject.getUser();
    }
}
