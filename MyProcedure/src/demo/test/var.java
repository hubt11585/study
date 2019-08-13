package demo.test;


public class var {

    public static void main(String[] args){
        int m = 500;
        Integer obj = m;
        int n = obj;
        System.out.println("n =  " + n);
        Integer obj1 = 500;
        System.out.println("iobj µÈ¼ÛÓÚ obj2 ?" + obj.equals(obj1));
    }
}
