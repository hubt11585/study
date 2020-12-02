package demo.knowledgepoints.spliterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100 ; i++) {
            list.add(i+"");
        }

        // ·Ö¸îµü´úÆ÷
        Spliterator spliterator = list.spliterator();
        Spliterator s1 = spliterator.trySplit();
        Spliterator s2 = spliterator.trySplit();

        System.out.println("===============spliterator================");
        spliterator.forEachRemaining((i) -> System.out.print(i+" "));
        System.out.println();
        System.out.println("===============s1================");
        s1.forEachRemaining((i) -> System.out.print(i+" "));
        System.out.println();
        System.out.println("===============s2================");
        s2.forEachRemaining((i) -> System.out.print(i+" "));
        System.out.println();
    }
}
