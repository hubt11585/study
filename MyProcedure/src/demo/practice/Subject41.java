package demo.practice;

/**
 * 【程序41】
 * 题目：求0，1，2，3，4，5，6，7所能组成的8位奇数个数。
 */
public class Subject41 {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5,6,7};
        compose(arr);
    }

    /**
     * 获取：0—7所能组成的奇数个数
     */
    private static void compose(int[] arr) {
        /**奇数特点，该数不能被2整数。故各位数是1，3，5，7，9**/
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(!isParity(arr[i])){
                oddCount++;
            }
        }
        /***************各位已经确定，剩下的数可以组成整数的个数*******************/
        int num = factorial(arr.length-1);
        /****************输出结果*********************/
        System.out.println("以下数字：");
        printArray(arr);
        System.out.println("可产生的奇数个数："+oddCount*num);

    }

    /**
     * 判断num是奇数还是偶数
     * @param num
     * @return
     */
    private static boolean isParity(int num) {
        if(num%2 == 1){
            return false;
        }else {
            return true;
        }
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

    /**
     * 打印数组
     * @param arr
     */
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
