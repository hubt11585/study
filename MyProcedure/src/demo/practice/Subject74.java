package demo.practice;

/**
 * ����һ������ nums��һ��ֵ val������Ҫԭ���Ƴ�������ֵ����val��Ԫ�أ������Ƴ���������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
 * Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 */
public class Subject74 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(new Subject74().removeElement(nums,3));
    }

    /**
     * ɾ��Ԫ��
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
