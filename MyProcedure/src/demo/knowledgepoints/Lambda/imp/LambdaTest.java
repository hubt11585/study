package demo.knowledgepoints.Lambda.imp;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("�߳�����");
        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Java 8֮ǰ��---------------------------------------------");
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }
        System.out.println("Java 8֮��---------------------------------------------");
        List features1 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features1.forEach(n -> System.out.println(n));
        System.out.println("ʹ��Java 8�ķ������ø����㣬����������::˫ð�Ų�������ʾ,��������C++����������������");
        features1.forEach(System.out::println);

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("��һ���ַ���J���ַ�����");
        filter(languages, (str)->str.startsWith("J"));

        System.out.println("���һ���ַ���a���ַ�����");
        filter(languages, (str)->str.endsWith("a"));

        System.out.println("��ӡȫ����");
        filter(languages, (str)->true);

        System.out.println("������ӡ��");
        filter(languages, (str)->false);

        System.out.println("��ӡ�ַ������ȳ���4:");
        filter(languages, (str)->str.length() > 4);

        List<String> names = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        // ����������and()��or()��xor()�߼��������ϲ�Predicate��
        // ����Ҫ�ҵ�������J��ʼ������Ϊ�ĸ���ĸ�����֣�����Ժϲ�����Predicate������
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        names.stream().filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("�ַ�����ͷΪ��J�� �� �ַ����ȵ���4��" + n));

        // ʹ��lambda���ʽ
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(n -> System.out.print(n+"; "));
        System.out.println();
        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);

        List<String> strList = Arrays.asList("abc","bcd","defg","jk");
        List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
        System.out.printf("ԭList : %s, ��list : %s", strList, filtered);

        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);

        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("ԭList : %s,  ƽ�������List : %s", numbers, distinct);

        //��ȡ���ֵĸ�������Сֵ�����ֵ���ܺ��Լ�ƽ��ֵ
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("List�����ֵ: " + stats.getMax());
        System.out.println("List����Сֵ: " + stats.getMin());
        System.out.println("List��֮��: " + stats.getSum());
        System.out.println("List��ƽ��ֵ: " + stats.getAverage());
    }

    public static void filter(List<String> names, Predicate<String> condition) {
        for(String name: names)  {
            if(condition.test(name)) {
                System.out.print(name + " ");
            }
        }
        System.out.println();
    }
}
