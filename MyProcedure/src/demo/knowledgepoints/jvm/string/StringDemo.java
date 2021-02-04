package demo.knowledgepoints.jvm.string;

public class StringDemo {
    public static void main(String[] args) {
        String a = "11";
        String b = new String("11");

        System.out.println("aµÄHashCode:"+a.hashCode());
        System.out.println("bµÄHashCode:"+b.hashCode());

        System.out.println("a==b :"+(a==b));
        System.out.println("a.equals(b) :"+ a.equals(b));
    }
}
