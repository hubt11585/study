package demo.practice;

/**
 * 【程序34】
 * 题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
 */
public class Subject34 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        /**********************打印数组*************************/
        printArray(arr);
        int m = 6;   //偏移量
        deviation(arr,m);
    }

    /**
     * 数组arr偏移m后的结果
     * @param arr
     * @param m
     */
    private static void deviation(int[] arr,int m) {
        int[] newArr = new int[m];
        int count = m-1;
        /*******************将最后m为数保存到新数组中********************/
        for (int i = arr.length-1; i >= arr.length-m ; i--) {
            newArr[count--] = arr[i];
        }

        /********************将数组中的数据往后移动m位***************************/
        for (int i =  arr.length-1; i >= m; i--) {
            arr[i] = arr[i-m];
        }

        /**********************数组前面的数据补充完整*************************/
        for (int i = 0; i < newArr.length; i++) {
            arr[i] = newArr[i];
        }

        /**********************打印数组*************************/
        printArray(arr);
    }

    /**
     * 打印数组
     * @param arr
     */
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
