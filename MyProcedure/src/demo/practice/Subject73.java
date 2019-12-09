package demo.practice;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class Subject73 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,5,6,6,7};
        System.out.println(new Subject73().removeDuplicates(nums));
    }

    /**
     * 删除重复元素
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int lengths = nums.length;
        if(lengths <=0 ){
            return 0;
        }
        int side = 0; //空位置
        int tmp = nums[0];
        boolean flag = true;
        for (int i = 1; i < lengths; i++) {
            if(tmp == nums[i]){
                if(flag){
                    side = i;
                    flag = false;
                }
            }else{
                tmp = nums[i];
                if(side > 0){
                    nums[side] = nums[i];
                    side++;
                }
            }
        }
        if(side == 0){
            return lengths;
        }
        return side;
    }
}
