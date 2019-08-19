package demo.practice;

/**
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数dividend除以除数divisor得到的商。
 */
public class Subject76 {
    public static void main(String[] args) {
        int dividend = 2147483647;
        int divisor = 3;
        System.out.println(2147483647/3);
        System.out.println(new Subject76().divide(dividend,divisor));
    }

    /**
     * 实现除法，通过减法的方式
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        //排除一些特殊结果
        if(dividend == 0 || divisor == Integer.MIN_VALUE){
            return 0;
        }
        if(divisor == 1){
            return dividend;
        }
        if(divisor == -1){
            if(dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }else{
                return -dividend;
            }
        }
        int result = 0;
        //处理成原码进行运算
        String s0 = Integer.toBinaryString(dividend);
        String s1 = Integer.toBinaryString(divisor);
        System.out.println(s0);
        System.out.println(s1);
        if(dividend > 0 && divisor > 0){
            for (int i = 1; i < s1.length(); i++) {
                if(s0.charAt(i) == '1'){
                   result =result + dividend >>> i;
                }
            }
        }
        if(dividend < 0 && divisor < 0){

        }
        if(dividend > 0 && divisor < 0) {

        }
        if(dividend < 0 && divisor > 0) {

        }
        return result;
    }
}
