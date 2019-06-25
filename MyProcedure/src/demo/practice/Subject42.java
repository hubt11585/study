package demo.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 【程序42】
 * 题目：输入一个偶数，判断该偶数等于哪两个素数之和。
 */
public class Subject42 {
    public static void main(String[] args) {
        System.out.println("请输入大于等于2的偶数：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        getTwoPrimeNum(num);
    }

    /**
     * 获取两个素数
     * @param num
     */
    private static void getTwoPrimeNum(int num) {
        List<Integer> primeNumberList = getPrimeNumber(2,num);
        for (int i = 0; i < primeNumberList.size(); i++) {
            for (int j = i; j < primeNumberList.size(); j++) {
                if(num == primeNumberList.get(i) + primeNumberList.get(j)){
                    System.out.println("该偶数为素数（"+primeNumberList.get(i)+"）和素数（"+primeNumberList.get(j)+"）的和");
                }
            }
        }
    }

    /**
     * 判断a和b之间有多少个素数
     * @param a
     * @param b
     */
    public static List<Integer> getPrimeNumber(int a, int b){
        List<Integer> primeNumberList = new ArrayList<>();
        if(a >= b){
            System.out.println("a不能大于等于b！");
        }
        for(int i=a;i<=b;i++){
            if(isPrimeNumber(i)){
                primeNumberList.add(i);
            }
        }
        return primeNumberList;
    }

    /**
     * 判断num是否是一个素数
     * @param i
     * @return
     */
    private static boolean isPrimeNumber(int i) {
        boolean flag = true;
        for(int j=2;j <= i/2;j++){
            if(i%j == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
