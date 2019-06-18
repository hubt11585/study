package demo.practice;

import java.util.Scanner;

/**
 * 【程序29】
 * 题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。
 */
public class Subject29 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,0};
        System.out.println("请输入一个1到8之间的数：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < arr.length-2 ; i++) {
            if(num >= arr[i] && num <= arr[i+1] ){
                for (int j = arr.length-1; j > i+1 ; j--) {
                    arr[j] = arr[j-1];
                }
                arr[i+1] = num;
                break;
            }
        }
        System.out.print("插入数字("+num+")之后的数组为：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
