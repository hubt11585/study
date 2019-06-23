package demo.practice;

import java.util.Scanner;

/**
 * 【程序37】
 * 题目：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+…+1/n,当输入n为奇数时，调用函数1/1+1/3+…+1/n
 */
public class Subject37 {

    private static double sum = 0;    //求和

    private static String str = "";   //拼接字符串

    public static void main(String[] args) {
        System.out.println("请输入一个正整数：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        specialDeal(num);
        System.out.print(str.substring(0,str.length()-2)+"的和为：");
        System.out.println(sum);
    }

    /**
     * 输入n为偶数时，调用函数求1/2+1/4+…+1/n,当输入n为奇数时，调用函数1/1+1/3+…+1/n
     * @param num
     */
    private static void specialDeal(int num) {
        sum = sum+ 1.0/num;
        if(num > 2){
            specialDeal(num-2);
        }
        str = str+"1/"+num+" + ";
    }
}
