package demo.knowledgepoints.compiler;

import com.itranswarp.compiler.JavaStringCompiler;

import java.lang.reflect.Method;
import java.util.Map;

public class CompilerDemo {

    public static void main(String[] args) throws Exception {
        // ����String���͵Ĵ���
        String source = "import java.util.Arrays;public class Main" +
                "{" +
                "public static void main(String[] args) {" +
                "System.out.println(Arrays.toString(args));" +
                "}" +
                "}";
        run(source, "1", "2");
    }



    public static Object run(String source, String...args) throws Exception {
        // ��������
        String className = "Main";
        String packageName = "top.fomeiherz";
        // ����������package top.fomeiherz;
        String prefix = String.format("package %s;", packageName);
        // ȫ������top.fomeiherz.Main
        String fullName = String.format("%s.%s", packageName, className);

        // ������
        JavaStringCompiler compiler = new JavaStringCompiler();
        // ���룺compiler.compile("Main.java", source)
        Map<String, byte[]> results = compiler.compile(className + ".java", prefix + source);
        // �����ڴ���byte��Class<?>����
        Class<?> clazz = compiler.loadClass(fullName, results);
        // ����ʵ��
        Object instance = clazz.newInstance();
        Method mainMethod = clazz.getMethod("main", String[].class);
        // String[]����ʱ����ʹ��Object[]��װ
        // ����ᱨ��java.lang.IllegalArgumentException: wrong number of arguments
        return mainMethod.invoke(instance, new Object[]{args});
    }
}
