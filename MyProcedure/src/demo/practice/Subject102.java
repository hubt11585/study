package demo.practice;

/**
 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
 * �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
 * �ж����Ƿ��ܹ��������һ��λ�á�
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
