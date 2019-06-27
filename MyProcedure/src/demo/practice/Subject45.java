package demo.practice;

import java.util.Scanner;

/**
 * 【程序45】
 * 题目：读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的＊。
 */
public class Subject45 {
    public static void main(String[] args) {
        System.out.println("请输入一个（1—50）正整数：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        printSymbol(num);
    }

    /**
     * 打印符号“＊”
     * @param num
     */
    private static void printSymbol(int num) {
        for (int i = 0; i < num ; i++) {
            System.out.print("＊");
        }
    }
}
