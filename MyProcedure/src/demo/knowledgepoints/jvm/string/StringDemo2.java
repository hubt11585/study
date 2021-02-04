package demo.knowledgepoints.jvm.string;

public class StringDemo2 {
    public static void main(String[] args) {
        final String s1 = "1";
        final String s2 = "2";
        String s3 = s1+s2;
        String s4 = "12";
        System.out.println("s3 == s4: "+(s3 == s4));
    }
}
