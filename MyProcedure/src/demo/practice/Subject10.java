package demo.practice;

import java.util.Scanner;

/**
 * 【程序10】
 * 题目：一球从100米高度自由落下，每次落地后反跳回原高度的一半；n次落地经过路线总长度和下次反弹的高度。
 */
public class Subject10 {

    public static void main(String[] args) {
        System.out.println("请选择第几次落地：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        sumLength(n);
    }

    public static void sumLength(int n){
        double height = 100;
        double sumLength = 100;
        for(int i=1; i<=n; i++){
            sumLength = sumLength + height;
            height = height/2;
        }
        System.out.println("总运动距离为："+sumLength);
        System.out.println("总运动距离为："+height);
    }
}
