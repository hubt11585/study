package demo.practice;

import java.util.Scanner;

/**
 * 【程序43】
 * 题目：判断一个素数能被几个9整除 （例如3能被9整除， 9除以3，等于3.） ，备注 ：数学除是后面的数除以前面的数
 * 尽管如此，该题还是感觉没有意义。
 */
public class Subject43 {
    public static void main(String[] args) {
        System.out.println("请输入一个素数");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        dealNum(num);
    }

    private static void dealNum(int num) {
        if(!isPrimeNumber(num)){
            System.out.println("您输入的数字不能素数！");
            return ;
        }

        int divisorNum = 9;
        while(true){
            if(divisorNum%num == 0 ){
                System.out.println("您输入的素数能被"+divisorNum/9+"个9整除！");
                break;
            }
            divisorNum = divisorNum + 9;
        }
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
