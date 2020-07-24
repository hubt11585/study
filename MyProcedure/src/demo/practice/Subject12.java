package demo.practice;

import java.util.Scanner;

/**
 * 【程序12】
 * 题目：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；利润高于10万元，低于20万元时，
 * 低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；20万到40万之间时，高于20万元的部分，可提成5%；
 * 40万到60万之间时高于40万元的部分，可提成3%；60万到100万之间时，高于60万元的部分，可提成1.5%，
 * 高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润I，求应发放奖金总数？
 */
public class Subject12 {

    public static void main(String[] args) {
        System.out.println("请输入您的业绩：");
        Scanner scanner = new Scanner(System.in);
        double profit= scanner.nextDouble();
        System.out.println("您得到的提成为："+premium(profit));
    }

    public static double premium(double profit){
        double premium = 0;
        if(profit <= 100000){
            premium = profit*0.1;
        }else if(profit > 100000 && profit <= 200000){
            premium = (profit - 100000) * 0.075 + premium(100000);
        }else if(profit > 200000 && profit <= 400000){
            premium = (profit - 200000) * 0.05 + premium(200000);
        }else if(profit > 400000 && profit <= 600000){
            premium = (profit - 400000) * 0.03 + premium(400000);
        }else if(profit > 600000 && profit <= 1000000){
            premium = (profit - 600000) * 0.015 + premium(600000);
        }else{
            premium = (profit - 1000000) * 0.01 + premium(1000000);
        }
        return premium;
    }
}
