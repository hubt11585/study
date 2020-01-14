package demo.practice;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class Subject102 {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,0,1};
        System.out.println(new Subject102().canJump(arr));
    }

    public boolean canJump(int[] nums) {
        int lengths =  nums.length;
        if(lengths <= 1) return true;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i+nums[i] > max && i <= max){
                max = i+nums[i];
            }else if(nums[i] == 0 && max < i+1 && lengths-1 != i){
                return false;
            }
        }
        return true;
    }
}
