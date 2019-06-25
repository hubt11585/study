package demo.practice;

/**
 * 【程序2】
 *  题目：判断101-200之间有多少个素数，并输出所有素数。
 *
 *  分析：什么是素数，不能被自己和1整除的数。
 */
public class Subject2 {
    public static void main(String[] args) {
        getPrimeNumber(101,200);
    }

    /**
     * 判断a和b之间有多少个素数
     * @param a
     * @param b
     */
    public static void getPrimeNumber(int a,int b){
        int sum = 0;
        if(a >= b){
            System.out.println("a不能大于等于b！");
        }
        for(int i=a;i<=b;i++){
            if(isPrimeNumber(i)){
                sum += 1;
                System.out.println("素数："+i);
            }
        }
        System.out.println("存在素数数量："+sum);
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
