package demo.design.iterator.imp;

import demo.design.iterator.inf.Iterator;
import demo.design.iterator.inf.List;

public class IteratorTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        List list = new ConcreteAggregate();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
