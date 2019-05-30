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
        int tmp = 0;
        int sum = 0;
        if(a >= b){
            System.out.println("a不能大于等于b！");
        }
        for(int i=a;i<=b;i++){
            tmp = 0;
            for(int j=2;j<i;j++){
                if(i%j == 0){
                    tmp = 1;
                    break;
                }
            }
            if(tmp==0){
                sum += 1;
                System.out.println("素数："+i);
            }
        }
        System.out.println("存在素数数量："+sum);
    }
}
