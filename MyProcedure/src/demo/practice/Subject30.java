package demo.practice;

/**
 * 【程序30】题目：将一个数组逆序输出。
 */
public class Subject30 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println("顺序打印：");
        printArray(arr);
        reverseOrder(arr);
    }

    /**
     * 将arr数组逆序处理
     * @param arr
     */
    private static void reverseOrder(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length/2 ; i++) {
            tmp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = tmp;
        }

        System.out.println("逆序打印：");
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
