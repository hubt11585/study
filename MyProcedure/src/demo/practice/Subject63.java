package demo.practice;

import java.util.Arrays;

/**
 * ����һ������n ������������nums�� һ��Ŀ��ֵtarget���ҳ�nums�е�����������ʹ�����ǵĺ���target��ӽ����������������ĺ͡�
 * �ٶ�ÿ������ֻ����Ψһ�𰸡�
 */
public class Subject63 {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(arr,target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        if(nums.length<=3){
            for (int i = 0; i < nums.length; i++) {
                sum = sum + nums[i];
            }
            return sum;
        }
        Arrays.sort(nums);
        double d = target/3.0;
        int begin = 1;
        int end = nums.length-2;
        int tmp = 0;
        while(begin < end){
            tmp = (begin+end)/2;
            if(nums[tmp] == d){
                break;
            }else if(nums[tmp] < d){
                begin = tmp;
            }else{
                end = tmp;
            }
            if(end - begin == 1){
                break;
            }
        }
        sum = nums[tmp] + nums[tmp-1] + nums[tmp+1];
        if(tmp == end){
            return nums[tmp] + nums[tmp-1] + nums[tmp+1];
        }else{
            return nums[tmp] + nums[tmp-1] + nums[tmp+1];
        }
    }
}
