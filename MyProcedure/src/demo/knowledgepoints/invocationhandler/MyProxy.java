package demo.knowledgepoints.invocationhandler;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class MyProxy {

    public static void main(String[] args) {
        try {
            MyInvocationHandler myInvocationHandler = new MyInvocationHandlerImpl();

            MyService myService = (MyService) MyProxy.getInstance(new BinServvice(),myInvocationHandler);
            myService.query();

            System.out.println("================================================");

            myService = (MyService) MyProxy.getInstance(new TaoService(),myInvocationHandler);
            myService.query();
        } catch (Exception e) {
            //
        }
    }

    public static Object getInstance(Object target, MyInvocationHandler myInvocationHandler) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = target.getClass().getInterfaces()[0];
        Class myInvocationHandlerClazz = myInvocationHandler.getClass().getInterfaces()[0];
        String interfaceName = clazz.getSimpleName();   //��ȡ�ӿ����ơ�
        String content = "";
        String line = "\n";//����
        String tab = "\t";//tab
        /****��װһ����start ***/
        String packageContent = "package demo.knowledgepoints.invocationhandler;" + line;
        String importContent = "import " + clazz.getName() + ";" + line
                              +"import " + myInvocationHandlerClazz.getName() + ";" + line;
        String clazzFirstLineContent = "public class $ProxyMy implements " + interfaceName + "{" + line;
        String myInvocationHandlerName= myInvocationHandlerClazz.getSimpleName();
        String filedContent = tab + "private " + interfaceName + " target;" + line
                + tab + "private " + myInvocationHandlerName + " myInvocationHandler;" + line;
        String constructorContent = tab + "public $ProxyMy (" + interfaceName + " target,"+myInvocationHandlerName+" myInvocationHandler){" + line
                + tab + tab + "this.target =target;"
                + line + tab + tab + "this.myInvocationHandler = myInvocationHandler;"
                + line + tab + "}" + line;


        String methodContent = "";
        /**��ȡ����ӿ��е�ȫ������***/
        Method[] methods = clazz.getDeclaredMethods();
        /**ѭ����װ�ӿ��еĸ�������**/
        for (Method method : methods) {
            //����ֵ����
            String returnTypeName = method.getReturnType().getSimpleName();
            //��������
            String methodName = method.getName();
            // �������͵����飨int,String�ȣ�
            Class args[] = method.getParameterTypes();
            String argsContent = "";
            String paramsContent = "";
            int flag = 0;
            for (Class arg : args) {
                //String
                String temp = arg.getSimpleName();
                //String
                //String p0
                argsContent += temp + " p" + flag + ",";
                //p0
                paramsContent += "p" + flag + ",";
                flag++;
            }
            if (argsContent.length() > 0) {
                argsContent = argsContent.substring(0, argsContent.lastIndexOf(",") - 1);
                paramsContent = paramsContent.substring(0, paramsContent.lastIndexOf(",") - 1);
            }

            methodContent += tab + "public " + returnTypeName + " " + methodName + "(" + argsContent + ") {" + line
                    + tab + tab + "myInvocationHandler.invoke();" + line
                    + tab + tab + "target." + methodName + "(" + paramsContent + ");" + line
                    + tab + "}" + line;

        }
        content += packageContent + importContent + clazzFirstLineContent + filedContent + constructorContent + methodContent + "}";
        /****��װһ����end ***/

        /****��������װ����д���ļ���***/
        File file = new File("src\\demo\\knowledgepoints\\invocationhandler\\$ProxyMy.java");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();
        } catch (Exception e) {

        }
        /***ʹ��JavaCompiler������Ҫ��װJDK��ֻ��JAR�޷�ʹ��**/
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
        Iterable units = fileMgr.getJavaFileObjects(file);
        JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
        t.call();
        fileMgr.close();

        /***������new������ȡ���ڴ���***/
        URL[] urls = new URL[]{new URL("file:d:\\Study\\AcceleateWorld\\study\\MyProcedure\\src\\\\")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class cls = urlClassLoader.loadClass("demo.knowledgepoints.invocationhandler.$ProxyMy");
        Class[] classes = new Class[]{clazz,myInvocationHandlerClazz};
        Constructor constructor = cls.getConstructor(classes);
        Object o  = constructor.newInstance(target,myInvocationHandler);
        return  o;
    }
}

