package demo.knowledgepoints.forkJoin;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class ForkJoinDemo {
    public static void main(String[] args) {
        int[] array = new int[20000000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        Instant instant = Instant.now();
        int sum = sum1(array);
        System.out.println(Duration.between(instant,Instant.now()).toMillis()+"ºÁÃë");
        System.out.println("sum = "+sum);
    }

    private static int sum1(int[] array) {
        int a = 0;
        for (int i = 0; i < array.length; i++) {
            a = a + array[i];
        }
        return a;
    }
}
