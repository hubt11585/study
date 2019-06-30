package demo.practice;

/**
 * 给定两个大小为 m 和 n 的有序数组nums1 和nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为O(log(m + n))。
 * 你可以假设nums1和nums2不会同时为空
 */
public class Subject51 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{1,2};
        double arr = findMedianSortedArrays(nums1,nums2);
        System.out.println(arr);
    }

    public static int PartSort(int arr[], int low, int high) {
        int data = arr[low];
        /**一次遍历的方法：插空法 定义一个data将arr[low]存起来，并把这个位置挖空*/
        while (low < high) {
            while (low < high && arr[high] >= data) {
                high--;
            }
            arr[low] = arr[high];
            /**从high，也就是后面往前遍历 找到比键值小的数据 插入到前面留下的空中 high位再次留下空来*/
            while (low < high && arr[low] <= data) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = data;
        /**循环退出后 low和high重合 将将键值赋给第low，并将low返回*/
        return low;
    }


    /**
     * 快速排序法
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int arr[], int low, int high) {
        if(low<high) {
            //防止发生栈溢出异常
            int index = PartSort(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    /**
     * 寻找中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        int[] arr = new int[a+b];
        double result = 0.0;
        if(a >= 2 && b >=2 ){
            if(nums1[0] <= nums1[1] && nums2[0] <= nums2[1] ){
                if(nums1[0] >= nums2[0]){
                    for (int i = 0; i < b; i++) {
                        arr[i] = nums2[i];
                    }
                    for (int i = 0; i < a; i++) {
                        arr[i+b] = nums1[i];
                    }
                }else{
                    for (int i = 0; i < a; i++) {
                        arr[i] = nums1[i];
                    }
                    for (int i = 0; i < b; i++) {
                        arr[i+a] = nums2[i];
                    }
                }
            }else if(nums1[0] >= nums1[1] && nums2[0] >= nums2[1]){
                if(nums1[a-1] <= nums2[b-1]){
                    for (int i = 0; i < a; i++) {
                        arr[i] = nums1[a-i-1];
                    }
                    for (int i = 0; i < b; i++) {
                        arr[i+a] = nums2[b-i-1];
                    }
                }else{
                    for (int i = 0; i < b; i++) {
                        arr[i] = nums1[b-i-1];
                    }
                    for (int i = 0; i < a; i++) {
                        arr[i+b] = nums2[a-i-1];
                    }
                }
            }else if(nums1[0] <= nums1[1] && nums2[0] >= nums2[1]){
                if(nums1[0] <= nums2[b-1]){
                    for (int i = 0; i < a; i++) {
                        arr[i] = nums1[i];
                    }
                    for (int i = 0; i < b; i++) {
                        arr[i+a] = nums2[b-i-1];
                    }
                }else{
                    for (int i = 0; i < b; i++) {
                        arr[i] = nums2[i];
                    }
                    for (int i = 0; i < a; i++) {
                        arr[i+b] = nums1[a-1-i];
                    }
                }
            }else if(nums1[0] >= nums1[1] && nums2[0] <= nums2[1]){
                if(nums1[a-1] <= nums2[0]){
                    for (int i = 0; i < a; i++) {
                        arr[i] = nums1[a-1-i];
                    }
                    for (int i = 0; i < b; i++) {
                        arr[i+a] = nums2[i];
                    }
                }else{
                    for (int i = 0; i < b; i++) {
                        arr[i] = nums2[i];
                    }
                    for (int i = 0; i < a; i++) {
                        arr[i+b] = nums1[a-1-i];
                    }
                }
            }
        }else{
            for (int i = 0; i < a; i++) {
                arr[i] = nums1[i];
            }
            for (int i = 0; i < b; i++) {
                arr[i+a] = nums2[i];
            }
        }
        int right = arr.length-1;
        int left = 0;

        quickSort(arr,left,right);

        int tmp = arr.length;
        if(tmp % 2 == 0){
            result = (arr[tmp/2] + arr[tmp/2 - 1]) / 2.0;
        }else{
            result = arr[tmp/2];
        }
        return result;
    }
}
