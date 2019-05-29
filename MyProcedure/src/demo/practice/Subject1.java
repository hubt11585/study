package demo.practice;

import java.util.Scanner;

/**
 * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少？
 * 分析 一月 1对， 2月 1对，3月 2对，4月 3对，5月5对，6月8对，7月13对，8月 21只
 */
public class Subject1 {

    public static void main(String[] args) {
        System.out.print("请输入你想知道的兔子数量的月份：");

        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();//获取输入的整数

        System.out.println(test(n));

        System.out.println(fun(n));

        scanner.close();
    }

    /**
     * 菜鸟写法
     * @param i
     * @return
     */
    public static int test(int i){
        int tot = 0;
        int a = 0;
        int b = 1;
        for(int j = 0;j<i; j++){
            tot = a+b;
            a = b;
            b = tot;
        }
        return a;
    }

    /**
     * 大神写法
     * @param
     * @return
     */
    private static int fun(int n){
        if(n==1 ||n==2)
            return 1;
        else
            return fun(n-1)+fun(n-2);
    }

}
