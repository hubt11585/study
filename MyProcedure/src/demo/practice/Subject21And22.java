package demo.practice;

/**
 * 【程序21】
 * 题目：求1+2!+3!+…+20!的和
 * 【程序22】
 * 题目：利用递归方法求5!。 
 */
public class Subject21And22 {

    public static void main(String[] args) {
        int sum = factorialSum(20);
        System.out.println("1+2!+3!+…+20!之和："+sum);
    }

    /**
     * 阶乘求和
     * @param num
     * @return
     */
    private static int factorialSum(int num) {
        int sum = 0;
        for (int j = 1; j <= num; j++) {
            sum = sum+factorial(j);
        }
        return sum;
    }

    /**
     * 计算num的阶乘！
     * @param num
     * @return
     */
    public static int factorial(int num){
        if(num == 1){
            return 1;
        }else{
           return num*factorial(num-1);
        }
    }
}
