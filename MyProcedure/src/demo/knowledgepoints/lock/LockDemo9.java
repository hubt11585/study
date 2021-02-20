package demo.knowledgepoints.lock;

import org.openjdk.jol.info.ClassLayout;

public class LockDemo9 {
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(ClassLayout.parseInstance(byte.class).toPrintable());
    }
}
