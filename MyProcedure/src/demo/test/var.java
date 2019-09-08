package demo.test;

import java.util.TreeMap;

public class var {
    public static void main(String[] agrs){
        TreeMap<Person, String> hm = new TreeMap<Person, String>(
                new MyComparator());
        hm.put(new Person("jack", 20), "1001");
        hm.put(new Person("rose", 18), "1002");
        hm.put(new Person("lucy", 19), "1003");
        hm.put(new Person("hmm", 17), "1004");
        hm.put(new Person("ll", 25), "1005");
        System.out.println(hm);
    }
}
