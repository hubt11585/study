package demo.test;

import demo.design.strategy.imp.Person;

import java.util.Iterator;
import java.util.TreeSet;

public class var {
    public static void main(String[] agrs){
        TreeSet<Person> ts = new TreeSet<>();
        ts.add(new Person("����", 23));
        ts.add(new Person("����", 13));
        ts.add(new Person("����", 13));
        ts.add(new Person("����", 43));
        ts.add(new Person("����", 33));
    }
}
