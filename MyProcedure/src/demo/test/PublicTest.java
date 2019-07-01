package demo.test;

import java.util.ArrayList;
import java.util.List;

public class PublicTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Integer num1= list.get(0);
        Integer num2= list.get(1);

        for (int i = num2; i < list.size(); i++) {
            list.remove(new Integer(list.get(i)));
            i--;
            System.out.println(list.get(i));
        }

    }
}
