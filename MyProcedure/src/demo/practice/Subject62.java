package demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组?nums，判断?nums?中是否存在三个元素 a，b，c ，
 * 使得?a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 */
public class Subject62 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,-1,-1,0,2,1,1};
        System.out.println(threeSum(nums));
    }

    /**
     * 获取满足条件的组合
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> tuples = new ArrayList<>();

        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue; //去重

            int l = i+1, r = nums.length-1;
            if(nums[l] < 0 && Integer.MIN_VALUE-nums[l] > nums[i]) continue; //如果溢出最小值则跳过
            if(nums[i] > 0 && Integer.MAX_VALUE-nums[l] < nums[i]) break; //溢出最大值直接结束，不可能会有新的三元组出现了

            while(l < r){
                if(nums[r] > -nums[i]-nums[l]){
                    while(l < r && nums[r-1] == nums[r]) r--; //右指针去重
                    r--;
                }
                else if(nums[r] < -nums[i]-nums[l]){
                    while(l < r && nums[l+1] == nums[l]) l++; //左指针去重
                    l++;
                }
                else{
                    tuples.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l < r && nums[r-1] == nums[r]) r--; //左指针去重
                    while(l < r && nums[l+1] == nums[l]) l++; //右指针去重
                    r--;
                    l++;
                }
            }
        }
        return tuples;
    }
}
