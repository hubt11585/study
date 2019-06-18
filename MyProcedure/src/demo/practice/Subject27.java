package demo.practice;

import java.util.Scanner;

/**
 * 【程序27】
 * 题目：对10个数进行排序
 */
public class Subject27 {

    public static void main(String[] args) {
        System.out.println("请输入10个整数：");
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[10];
        for (int i = 0; i <10 ; i++) {
            System.out.println("请输入第"+(i+1)+"个数:");
            int num = scanner.nextInt();
            arr[i] = num;
        }

        sortInt(arr);
    }

    /**
     * 对数组arr进行排序
     * @param arr
     */
    private static void sortInt(int[] arr) {
        int tmp = 0;
        for(int i =0 ;i<arr.length;i++){
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i] > arr[j]){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        System.out.println("从小到大排序为：");
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
