package demo.practice;

/**
 * 【程序100】
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Subject100 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        System.out.println(new Subject100().maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {
        int maxSum ;
        int tmpSum = 0;
        int lengths = nums.length;
        if (lengths > 0) {maxSum = nums[0]; tmpSum = maxSum;} else return 0;
        for (int i = 1; i < lengths ; i++) {
            boolean flag = false;

            if(nums[i] > maxSum){
                maxSum = nums[i];
                flag = true;
            }
            if(tmpSum + nums[i] > maxSum) {
                maxSum = tmpSum + nums[i];
                flag = true;
            }

            if(!flag){
                if(tmpSum + nums[i] <= 0){
                    tmpSum = 0;
                }else{
                    tmpSum += nums[i];
                }
            }else{
                tmpSum = maxSum;
            }
        }
        return maxSum;
    }
}
