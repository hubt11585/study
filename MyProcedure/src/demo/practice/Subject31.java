package demo.practice;

import java.util.Scanner;

/**
 * 【程序31】
 * 题目：取一个整数a从右端开始的4～7位。
 */
public class Subject31 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入一个操作8位的整数");
        String num = scanner.next();
        intercept(num);
    }

    /**
     * 截取num
     * @param num
     */
    private static void intercept(String num) {
        char[] arr = num.toCharArray();
        int j=0;
        System.out.print("截取结果为：");
        for(int i = arr.length-1 ; i >= 0;i--){
            j++;
            if(j >= 4 && j<=7){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
