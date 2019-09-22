package demo.test;

import java.util.concurrent.ThreadLocalRandom;

public class PublicTest {
    static <T extends String> T[] toArray(T... args) {
        return args;
    }

    static <T extends String> T[] pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
        }
        throw new AssertionError(); // Can't get here
    }

    public static void main(String[] args) {
        String[] attributes = pickTwo("Good", "Fast", "Cheap");
        System.out.println(attributes[0]+" : "+attributes[1]);
    }
}
