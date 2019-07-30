package demo.practice;

import java.util.Scanner;

/**
 * 【程序24】
 * 题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
 */
public class Subject24 {

    public static void main(String[] args) {
        System.out.println("请输入需要分析的正整数：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        analysisInt(num);
    }

    /**
     * 分析正整数
     * @param num
     */
    private static void analysisInt(int num) {
        String tmpStr = String.valueOf(num);
        char[] arrStr =tmpStr.toCharArray();
        System.out.println("该正整数是"+arrStr.length+"位数。");
        System.out.println("倒序打印为：");
        for (int i = arrStr.length-1; i >= 0; i--) {
            System.out.print(arrStr[i]+" ");
        }
    }
}
