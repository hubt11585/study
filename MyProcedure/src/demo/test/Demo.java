package demo.test;

public class Demo {
    public static void main(String[] args){
        // 字符型
        boolean a = 100>10;
        boolean b = 100<10;
        System.out.println("100>10 = " + a);
        System.out.println("100<10 = " + b);
        if(a){
            System.out.println("100<10是对的");
        }else{
            System.out.println("100<10是错的");
        }
    }
}
