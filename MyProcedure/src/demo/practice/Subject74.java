package demo.practice;

/**
 * 给定一个数组 nums和一个值 val，你需要原地移除所有数值等于val的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Subject74 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(new Subject74().removeElement(nums,3));
    }

    /**
     * 删除元素
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int lengths = nums.length;
        if(lengths <=0 ){
            return 0;
        }
        int side = 0;
        for (int i = 0; i < lengths; i++) {
            if(val != nums[i]){
                nums[side] = nums[i];
                side++;
            }
        }
        return side;
    }
}
