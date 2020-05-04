package demo.knowledgepoints.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class MyIntrospector {
    public static void main(String[] args) {
        try {
            Bean bean = new Bean();
            BeanInfo beanInfo = Introspector.getBeanInfo(Bean.class);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                System.out.println(propertyDescriptors[i].getPropertyType());
                Method writeMethod = propertyDescriptors[i].getWriteMethod();
                if(writeMethod != null){
                    if (propertyDescriptors[i].getName().equals("age")) {
                        writeMethod.invoke(bean, 11);
                    }
                    if (propertyDescriptors[i].getName().equals("name")) {
                        writeMethod.invoke(bean, "ÀöÀö");
                    }
                }
            }
            System.out.println(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
