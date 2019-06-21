package demo.practice;

/**
 * 【程序33】
 * 题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。
 */
public class Subject33 {

    public static void main(String[] args) {
        int[] arr = new int[]{44,56,89,32,11,78,55,82,02,68,44,27};
        printArray(arr);
        deal(arr);
    }

    private static void deal(int[] arr) {
        int maxNum = arr[0];    //最大数
        int minNum = arr[0];    //最小数
        int maxPosition = 0;    //最大数在数组的位置。
        int minPosition = 0;    //最小数在数组的位置。
        for (int i = 1; i <  arr.length; i++) {
            if(arr[i] > maxNum){
                maxNum = arr[i];
                maxPosition = i;
            }
            if(arr[i] < minNum){
                minNum = arr[i];
                minPosition = i;
            }
        }

        /*********重组数组（最大的与第一个元素交换，最小的与最后一个元素）************/
        int tmp = 0;
        tmp = arr[0];
        arr[0] = arr[maxPosition];
        arr[maxPosition] = tmp;

        tmp = arr[arr.length-1];
        arr[arr.length-1] = arr[minPosition];
        arr[minPosition] = tmp;

        /*********打印数组***********/
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
