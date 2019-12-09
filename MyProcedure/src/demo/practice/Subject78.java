package demo.practice;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Subject78 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,3,3};
        new Subject78().nextPermutation(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    /**
     * 下一个最大值
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int lengths = nums.length;
        int size = -1;
        for (int i = lengths-1; i >= 0; i--) {
            if(i-1 >= 0 && nums[i-1] < nums[i]){
                size = i-1;
                break;
            }
        }
        //如果没有最大的值了
        if(size == -1){
            for (int i = 0 ,j= lengths-1; i <= j ; i++,j--) {
                int tmp = 0;
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }else{ //处理size后边的数据，重新整理成一个最小数组。
            //找到比size位置大的数中的最小数。
            int tmp = nums[size+1];
            int sizeExchange = size+1;
            for (int i = size+1; i < lengths ; i++) {
                //这里可以优化
                if(nums[i] <= tmp && nums[i] > nums[size]){
                    tmp = nums[i];
                    sizeExchange = i;
                }
            }
            nums[sizeExchange] = nums[size];
            nums[size] = tmp;
            //剩余数据重新重小到大排序
            for (int i = size+1 ,j= lengths-1; i <= j ; i++,j--) {
                int tmp0 = 0;
                tmp0 = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp0;
            }
        }
    }
}
