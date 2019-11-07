package demo.knowledgepoints.annotation;

import org.apache.poi.ss.formula.functions.T;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射获取注解
 */
public class AnnotaionDemo {
    public static void main(String[] args) throws Exception {
        Class<T> clazz = (Class<T>) Class.forName("demo.knowledgepoints.annotation.Student");
        //判断注解是否存在
        if(clazz.isAnnotationPresent(MyAnnotaion.class)){
            System.out.println("存在注解：MyAnnotaion");
        }

        //获取注解列表
        Annotation[] annotaions = clazz.getAnnotations();
        for (int i = 0; i < annotaions.length; i++) {
            System.out.println("注解："+annotaions[i]);
        }

        //获取注解内容
        MyAnnotaion myAnnotaion = clazz.getAnnotation(MyAnnotaion.class) ;
        System.out.println("注解的值为："+myAnnotaion.value());

        //获取方法上的注解内容
        Field field = clazz.getDeclaredField("id");

        //方法上注解是否存在
        field.isAnnotationPresent(MyFieldAnnotaion.class);
        //方法注解列表
        field.getAnnotations();

        //获取方法上的注解内容
        MyFieldAnnotaion myFieldAnnotaion = field.getAnnotation(MyFieldAnnotaion.class);
        System.out.println("value:"+myFieldAnnotaion.value()+"; type:"+myFieldAnnotaion.type()+"; lengths:"+myFieldAnnotaion.lengths());

        Student student = (Student) getbean("demo.knowledgepoints.annotation.Student");
        System.out.println(student);
    }

    public static Object getbean(String className) throws Exception{
        Class<T> clazz = (Class<T>) Class.forName(className);
        //判断注解是否存在(该注解被当成标记使用)
        if(!clazz.isAnnotationPresent(MyAnnotaion.class)){
            throw new Exception("该类缺失注解“MyAnnotaion”，不能通过反射获取bean");
        }

        //创建实体类
        Object object = clazz.newInstance();

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            //获取字段名
            String name = fields[i].getName();

            //过滤序列
            if (name.equals("serialVersionUID")) {
                continue;
            }

            //组装SET方法
            Class<?> type = clazz.getDeclaredField(name).getType();

            // 首字母大写
            String replace = name.substring(0, 1).toUpperCase()
                    + name.substring(1);
            Method setMethod = clazz.getMethod("set" + replace, type);
            //获取字段值
            Field field = clazz.getDeclaredField(name);
            MyFieldAnnotaion myFieldAnnotaion = field.getAnnotation(MyFieldAnnotaion.class);
            String value = myFieldAnnotaion.value();
            //执行set方法
            if (value != null && !"".equals(value)) {
                // ---判断读取数据的类型（判断部分类型）
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
