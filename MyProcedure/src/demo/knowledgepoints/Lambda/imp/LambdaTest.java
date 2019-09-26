package demo.knowledgepoints.Lambda.imp;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("线程启动");
        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Java 8之前：---------------------------------------------");
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }
        System.out.println("Java 8之后：---------------------------------------------");
        List features1 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features1.forEach(n -> System.out.println(n));
        System.out.println("使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示,看起来像C++的作用域解析运算符");
        features1.forEach(System.out::println);

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("第一个字符是J的字符串：");
        filter(languages, (str)->str.startsWith("J"));

        System.out.println("最后一个字符是a的字符串：");
        filter(languages, (str)->str.endsWith("a"));

        System.out.println("打印全部：");
        filter(languages, (str)->true);

        System.out.println("都不打印：");
        filter(languages, (str)->false);

        System.out.println("打印字符串长度超过4:");
        filter(languages, (str)->str.length() > 4);

        List<String> names = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
        // 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        names.stream().filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("字符串开头为“J” 且 字符长度等于4：" + n));

        // 使用lambda表达式
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(n -> System.out.print(n+"; "));
        System.out.println();
        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);

        List<String> strList = Arrays.asList("abc","bcd","defg","jk");
        List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
        System.out.printf("原List : %s, 新list : %s", strList, filtered);

        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);

        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("原List : %s,  平方后的新List : %s", numbers, distinct);

        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("List的最大值: " + stats.getMax());
        System.out.println("List的最小值: " + stats.getMin());
        System.out.println("List的之和: " + stats.getSum());
        System.out.println("List的平均值: " + stats.getAverage());
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
