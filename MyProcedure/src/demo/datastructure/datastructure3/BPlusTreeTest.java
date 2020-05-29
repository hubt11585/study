package demo.datastructure.datastructure3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BPlusTreeTest {
    // 测试
    public static void main(String[] args) {
        int size = 10;
        int order = 3;
        testRandomInsert(size, order);
        testRandomSearch(size, order);
        testRandomRemove(size, order);
    }

    private static void testRandomRemove(int size, int order) {
        BPlusTree<Integer, Integer> tree = new BPlusTree<Integer, Integer>(order);
        System.out.println("\nTest random remove " + size + " datas, of order:"
                + order);
        Random random = new Random();
        boolean[] a = new boolean[size + 10];
        List<Integer> list = new ArrayList<Integer>();
        int randomNumber = 0;
        System.out.println("Begin random insert...");
        for (int i = 0; i < size; i++) {
            randomNumber = random.nextInt(size);
            a[randomNumber] = true;
            list.add(randomNumber);
            tree.insertOrUpdate(randomNumber, randomNumber);
        }
        tree.printBPlusTree();
        System.out.println("Begin random remove...");
        long current = System.currentTimeMillis();
        for (int j = 0; j < size; j++) {
            randomNumber = list.get(j);
            if (a[randomNumber]) {
                if (tree.remove(randomNumber) == null) {
                    System.err.println("得不到数据:" + randomNumber);
                    break;
                } else {
                    a[randomNumber] = false;
                }
            }
        }
        long duration = System.currentTimeMillis() - current;
        System.out.println("time elpsed for duration: " + duration);
        tree.printBPlusTree();
        System.out.println("树高："+tree.getHeight());
    }

    private static void testRandomSearch(int size, int order) {
        BPlusTree<Integer, Integer> tree = new BPlusTree<Integer, Integer>(order);
        System.out.println("\nTest random search " + size + " datas, of order:"
                + order);
        Random random = new Random();
        boolean[] a = new boolean[size + 10];
        int randomNumber = 0;
        System.out.println("Begin random insert...");
        for (int i = 0; i < size; i++) {
            randomNumber = random.nextInt(size);
            a[randomNumber] = true;
            tree.insertOrUpdate(randomNumber, randomNumber);
        }
        tree.printBPlusTree();
        System.out.println("Begin random search...");
        long current = System.currentTimeMillis();
        for (int j = 0; j < size; j++) {
            randomNumber = random.nextInt(size);
            if (a[randomNumber]) {
                if (tree.get(randomNumber) == null) {
                    System.err.println("得不到数据:" + randomNumber);
                    break;
                }
            }
        }
        long duration = System.currentTimeMillis() - current;
        System.out.println("time elpsed for duration: " + duration);
    }

    private static void testRandomInsert(int size, int order) {
        BPlusTree<Integer, Integer> tree = new BPlusTree<Integer, Integer>(order);
        System.out.println("\nTest random insert " + size + " datas, of order:"
                + order);
        Random random = new Random();
        int randomNumber = 0;
        long current = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            randomNumber = random.nextInt(size * 10);
            System.out.print(randomNumber + " ");
            tree.insertOrUpdate(randomNumber, randomNumber);
        }
        long duration = System.currentTimeMillis() - current;
        System.out.println("time elpsed for duration: " + duration);
        tree.printBPlusTree();
        System.out.println("树高："+tree.getHeight());
    }
}
