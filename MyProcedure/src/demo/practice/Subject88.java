package demo.practice;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 */
public class Subject88 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{1,2,3};
        int number = new Subject88().firstMissingPositive(arrInt);
        System.out.println(number);
    }

    public int firstMissingPositive(int[] nums) {
        int lengths = nums.length;
        if(lengths <= 0){
            return 1;
        }
        QuickSort(nums,0,lengths-1);
        if(nums[0] > 1){
            return 1;
        }
        for (int i = 1; i < lengths; i++) {
            if(nums[i] > 1){
                if(nums[i] - nums[i-1] > 1){
                    if(nums[i-1] > 0){
                        return nums[i-1]+1;
                    }else{
                        return 1;
                    }
                }
            }
        }
        if(nums[nums.length-1] > 0){
            return nums[nums.length-1]+1;
        }else{
            return 1;
        }
    }

    public int PartSort(int arr[], int low, int high) {
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

    public void QuickSort(int arr[], int low, int high) {
        if(low<high) {
            //防止发生栈溢出异常
            int index = PartSort(arr, low, high);
            QuickSort(arr, low, index - 1);
            QuickSort(arr, index + 1, high);
        }
    }
}
