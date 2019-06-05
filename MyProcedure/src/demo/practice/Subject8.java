package demo.practice;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 【程序8】
 * 题目：求s=a+aa+aaa+aaaa+aa…a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。输出结果的形式如：2+22+222=246；
 */
public class Subject8 {
    public static void main(String[] args) {
        System.out.println("请输入数字1(小于10)：" );
        Scanner scanner=new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println("请输入数字2(1-10)：" );
        int b = scanner.nextInt();
        sum(a,b);
    }

    /**
     * 求和
     * @param num1
     * @param num2
     */
    public static void sum(int num1,int num2) {
        String numStr = "";
        String result = "";
        BigDecimal bigDecimal = new BigDecimal("8");
        for(int i=1;i< num1; i++ ){
            numStr = numStr+num2;
            if(i==1){
                result = result+numStr;
            }else{
                result = result+"+"+numStr;
            }
            bigDecimal = bigDecimal.add(new BigDecimal(numStr));
        }
        result = result +"=" +bigDecimal.toString();
        System.out.println("结果："+result);
    }
}
