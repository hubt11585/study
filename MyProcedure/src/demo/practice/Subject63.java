package demo.practice;

import java.util.Arrays;

/**
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 */
public class Subject63 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(arr,target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        if(nums.length<=3){
            for (int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
            }
            return sum;
        }
        Arrays.sort(nums);
        double d = target/3.0;
        int begin = 1;
        int end = nums.length-2;
        int tmp = 0;
        while(begin < end){
            tmp = (begin+end)/2;
            if(nums[tmp] == d){
                break;
            }else if(nums[tmp] < d){
                begin = tmp;
            }else{
                end = tmp;
            }
            if(end - begin == 1){
                break;
            }
        }
        sum = nums[tmp] + nums[tmp-1] + nums[tmp+1];
        if(tmp == end){
            return nums[tmp] + nums[tmp-1] + nums[tmp+1];
        }else{
            return nums[tmp] + nums[tmp-1] + nums[tmp+1];
        }
    }
}
