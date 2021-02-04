package demo.knowledgepoints.jvm.classloader;

import sun.misc.Launcher;

import java.net.URL;

public class ClassLoaderDemo1 {
    public static void main(String[] args) {
        String[] split = System.getProperty("sun.boot.class.path").split(";");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        System.out.println("========================================");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urLs.length; i++) {
            System.out.println(urLs[i]);
        }
    }
}
