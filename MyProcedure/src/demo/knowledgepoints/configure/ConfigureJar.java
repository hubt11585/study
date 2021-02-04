package demo.knowledgepoints.configure;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ConfigureJar {

    public static void main(String[] args) throws Exception {
        String path = "E:\\GitHub\\study\\MyProcedure\\lib\\compiler-1.0.jar";//�ⲿjar����·��
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();//���е�Class����
        Map<Class<?>, Annotation[]> classAnnotationMap = new HashMap<Class<?>, Annotation[]>();//ÿ��Class�����ϵ�ע�Ͷ���
        Map<Class<?>, Map<Method, Annotation[]>> classMethodAnnoMap = new HashMap<Class<?>, Map<Method,Annotation[]>>();//ÿ��Class������ÿ�������ϵ�ע�Ͷ���

        JarFile jarFile = new JarFile(new File(path));
        URL url = new URL("file:" + path);
        ClassLoader loader = new URLClassLoader(new URL[]{url});//�Լ������classLoader�࣬���ⲿ·��Ҳ�ӵ�load·���ʹϵͳȥ��·��load����
        Enumeration<JarEntry> es = jarFile.entries();
        while (es.hasMoreElements()) {
            JarEntry jarEntry = (JarEntry) es.nextElement();
            String name = jarEntry.getName();
            if(name != null && name.endsWith(".class")){//ֻ������.class�ļ���û�н��������jar��
                //Ĭ��ȥϵͳ�Ѿ������·�����Ҷ�������ⲿjar��������
                Class<?> c = loader.loadClass(name.replace("/", ".").substring(0,name.length() - 6));//�Լ������loader·�������ҵ�
                System.out.println(c);
                classes.add(c);
                Annotation[] classAnnos = c.getDeclaredAnnotations();
                classAnnotationMap.put(c, classAnnos);
                Method[] classMethods = c.getDeclaredMethods();
                Map<Method, Annotation[]> methodAnnoMap = new HashMap<Method, Annotation[]>();
                for(int i = 0;i<classMethods.length;i++){
                    Annotation[] a = classMethods[i].getDeclaredAnnotations();
                    methodAnnoMap.put(classMethods[i], a);
                }
                classMethodAnnoMap.put(c, methodAnnoMap);
            }
        }
        System.out.println(classes.size());
    }
}
