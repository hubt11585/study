package demo.knowledgepoints.classLoader;

import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTest {
    public static void main(String[] args) {
        /****file:/// 表示本地文件****/

        String v1dir = "file:///E:\\GitHub\\study\\MyProcedure\\out\\production\\MyProcedure\\demo\\knowledgepoints\\classLoader\\";
        String v2dir = "file:///E:\\GitHub\\study\\MyProcedure\\out\\production\\MyProcedure\\demo\\knowledgepoints\\classLoader\\imp\\";
        URLClassLoader v1 = null;
        URLClassLoader v2 = null;
        try {
            v1 = new URLClassLoader(new URL[]{new URL(v1dir)});
            v2 = new URLClassLoader(new URL[]{new URL(v2dir)});
            //必须使用全名，即需要包含包名。
            Class<?> depv1Class = v1.loadClass("demo.knowledgepoints.classLoader.Dep");
            Object depv1 = depv1Class.getConstructor().newInstance();
            depv1Class.getMethod("print").invoke(depv1);
            //必须使用全名，即需要包含包名。
            Class<?> depv2Class = v2.loadClass("demo.knowledgepoints.classLoader.imp.Dep");
            Object depv2 = depv2Class.getConstructor().newInstance();
            depv2Class.getMethod("print").invoke(depv2);

            System.out.println(depv1Class.equals(depv2Class));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
