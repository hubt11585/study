package demo.knowledgepoints.jvm;

import org.openjdk.jol.info.ClassLayout;

public class JvmTest4 {

    static int[] a = new int[]{1,2,3};

    public static void main(String[] args) {

        JvmTest4 jvmTest4 = new JvmTest4();
        System.out.println(ClassLayout.parseInstance(jvmTest4).toPrintable());
    }
}
