package demo.test;

import demo.design.strategy.imp.Person;

import java.util.Iterator;
import java.util.TreeSet;

public class var {
    public static void main(String[] agrs){
        TreeSet<Person> ts = new TreeSet<>();
        ts.add(new Person("张三", 23));
        ts.add(new Person("李四", 13));
        ts.add(new Person("周七", 13));
        ts.add(new Person("王五", 43));
        ts.add(new Person("赵六", 33));
    }
}
