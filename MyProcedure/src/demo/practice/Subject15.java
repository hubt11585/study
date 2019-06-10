package demo.practice;

/**
 * 【程序15】
 * 题目：输入三个整数x,y,z，请把这三个数由小到大输出
 */
public class Subject15 {
    public static void main(String[] args) {
        minNum(7,3,5);
    }

    /**
     * 获取最小数
     * @param a
     * @param b
     * @param c
     */
    public static void minNum(int a,int b,int c){
        int tmp = 0;
        int[] nums= {a,b,c};
        int[] numTmp = new int[3];
        for(int i=0 ; i<2;i++){
            for (int j = i+1; j <= 2; j++) {
                if(nums[j] < nums[i]){
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        for (int i = 0; i < nums.length ; i++) {
            System.out.println(nums[i]);
        }
    }
}
