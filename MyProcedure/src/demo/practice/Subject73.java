package demo.practice;

/**
 * ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 */
public class Subject73 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,5,6,6,7};
        System.out.println(new Subject73().removeDuplicates(nums));
    }

    /**
     * ɾ���ظ�Ԫ��
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int lengths = nums.length;
        if(lengths <=0 ){
            return 0;
        }
        int side = 0; //��λ��
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
