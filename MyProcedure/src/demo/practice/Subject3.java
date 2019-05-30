package demo.practice;

/***
 * 【程序3】
 * 题目：打印出所有的”水仙花数”，所谓”水仙花数”是指一个三位数，其各位数字立方和等于该数本身。例如：153是一个”水仙花数”，因为153=1的三次方＋5的三次方＋3的三次方。
 */
public class Subject3 {
    public static void main(String[] args) {
        for(int i= 100 ; i<=999;i++){
            if(isNarcissus(i)){
                System.out.println("水仙花数："+i);
            }
        }
    }

    public static boolean  isNarcissus(int a){

        int num1 = 0;  //个位
        int num2 = 0;  //十位
        int num3 = 0;  //百位
        num3 = a/100;
        num2 = (a - num3*100)/10;
        num1 = a - num3*100 - num2*10;

        if(Math.pow(num1,3) + Math.pow(num2,3) + Math.pow(num3,3) ==a){
            return true;
        }
        return false;
    }
}
