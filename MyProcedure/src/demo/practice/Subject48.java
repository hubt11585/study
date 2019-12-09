package demo.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 【程序48】
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 */
public class Subject48 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,5,6,7,9,76,43,22,11};
        int target = 11;
        int[] result = twoSum(nums,target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * 获取满足条件的数组下标
     * @param nums
     * @param target
     */
    private static int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        //遍历查找
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            //判断键值是否存在
            if(map.containsKey(target - a)){
                temp[0] = map.get(target - a);
                temp[1] = i;
                return temp;
            }else {//如果找不到则存进去
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
