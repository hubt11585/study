package demo.practice;
/**
 * ����һ������n ������������nums�� һ��Ŀ��ֵtarget���ҳ�nums�е�����������ʹ�����ǵĺ���target��ӽ����������������ĺ͡�
 * �ٶ�ÿ������ֻ����Ψһ�𰸡�
 */
public class Subject63 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1};
        int target = 0;
        System.out.println(threeSumClosest(arr,target));
    }

    /**
     * ��ȡ��ӽ���������֮��
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        if(nums.length<=3){
            for (int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
            }
            return sum;
        }
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int tmp = nums[i] + nums[j] + nums[k];
                    if(tmp == target ){
                        return target;
                    }else if(tmp > target){
                        if(tmp < max){
                            max = tmp;
                        }
                    }else{
                        if(tmp > min){
                            min = tmp;
                        }
                    }
                }
            }
        }
        if(max == Integer.MAX_VALUE){
            return min;
        }
        if(min == Integer.MIN_VALUE){
            return max;
        }
        if(Math.abs(max-target) <= Math.abs(target-min)){
            sum = max;
        }else{
            sum = min;
        }
        return sum;
    }
}
