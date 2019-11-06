package demo.practice;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class Subject92 {

    public static void main(String[] args) {
        int[] arrInt = new int[]{2,3,1,1,4,2,1};
        System.out.println(new Subject92().jump(arrInt));
    }

    public int jump(int[] nums) {
        //小于等于1的都不需要跳
        int lengths = nums.length;
        if(lengths <= 1){
            return 0;
        }
        int reach = 0;  //当前能走的最远距离
        int nextreach = nums[0];
        int step = 0;  //需要步数
        for(int i = 0;i<lengths;i++){
            //贪心算法核心：这一步是不是可以比上一步得到更多步数，可以则取最新的路线。
            nextreach = Math.max(i+nums[i],nextreach);
            if(nextreach >= lengths-1) return (step+1);
            if(i == reach){
                step++;
                reach = nextreach;
            }
        }
        return step;
    }
}
