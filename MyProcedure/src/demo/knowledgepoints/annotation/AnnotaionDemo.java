package demo.knowledgepoints.annotation;

import org.apache.poi.ss.formula.functions.T;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ͨ�������ȡע��
 */
public class AnnotaionDemo {
    public static void main(String[] args) throws Exception {
        Class<T> clazz = (Class<T>) Class.forName("demo.knowledgepoints.annotation.Student");
        //�ж�ע���Ƿ����
        if(clazz.isAnnotationPresent(MyAnnotaion.class)){
            System.out.println("����ע�⣺MyAnnotaion");
        }

        //��ȡע���б�
        Annotation[] annotaions = clazz.getAnnotations();
        for (int i = 0; i < annotaions.length; i++) {
            System.out.println("ע�⣺"+annotaions[i]);
        }

        //��ȡע������
        MyAnnotaion myAnnotaion = clazz.getAnnotation(MyAnnotaion.class) ;
        System.out.println("ע���ֵΪ��"+myAnnotaion.value());

        //��ȡ�����ϵ�ע������
        Field field = clazz.getDeclaredField("id");

        //������ע���Ƿ����
        field.isAnnotationPresent(MyFieldAnnotaion.class);
        //����ע���б�
        field.getAnnotations();

        //��ȡ�����ϵ�ע������
        MyFieldAnnotaion myFieldAnnotaion = field.getAnnotation(MyFieldAnnotaion.class);
        System.out.println("value:"+myFieldAnnotaion.value()+"; type:"+myFieldAnnotaion.type()+"; lengths:"+myFieldAnnotaion.lengths());

        Student student = (Student) getbean("demo.knowledgepoints.annotation.Student");
        System.out.println(student);
    }

    public static Object getbean(String className) throws Exception{
        Class<T> clazz = (Class<T>) Class.forName(className);
        //�ж�ע���Ƿ����(��ע�ⱻ���ɱ��ʹ��)
        if(!clazz.isAnnotationPresent(MyAnnotaion.class)){
            throw new Exception("����ȱʧע�⡰MyAnnotaion��������ͨ�������ȡbean");
        }

        //����ʵ����
        Object object = clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            //��ȡ�ֶ���
            String name = fields[i].getName();

            //��������
            if (name.equals("serialVersionUID")) {
                continue;
            }

            //��װSET����
            Class<?> type = clazz.getDeclaredField(name).getType();

            // ����ĸ��д
            String replace = name.substring(0, 1).toUpperCase()
                    + name.substring(1);
            Method setMethod = clazz.getMethod("set" + replace, type);
            //��ȡ�ֶ�ֵ
            Field field = clazz.getDeclaredField(name);
            MyFieldAnnotaion myFieldAnnotaion = field.getAnnotation(MyFieldAnnotaion.class);
            String value = myFieldAnnotaion.value();
            //ִ��set����
            if (value != null && !"".equals(value)) {
                // ---�ж϶�ȡ���ݵ����ͣ��жϲ������ͣ�
                if (type.isAssignableFrom(String.class)) {
                    setMethod.invoke(object, value);
                } else if (type.isAssignableFrom(int.class)
                        || type.isAssignableFrom(Integer.class)) {
                    setMethod.invoke(object, Integer.parseInt(value));
                } else if (type.isAssignableFrom(Double.class)
                        || type.isAssignableFrom(double.class)) {
                    setMethod.invoke(object, Double.parseDouble(value));
                } else if (type.isAssignableFrom(Boolean.class)
                        || type.isAssignableFrom(boolean.class)) {
                    setMethod.invoke(object, Boolean.parseBoolean(value));
                }
            }
        }
        return object;
    }
}
