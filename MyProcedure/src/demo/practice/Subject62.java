package demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ������ n ������������?nums���ж�?nums?���Ƿ��������Ԫ�� a��b��c ��
 * ʹ��?a + b + c = 0 ���ҳ��������������Ҳ��ظ�����Ԫ�顣
 */
public class Subject62 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,-1,-1,0,2,1,1};
        System.out.println(threeSum(nums));
    }

    /**
     * ��ȡ�������������
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> tuples = new ArrayList<>();

        for(int i = 0; i < nums.length-2; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue; //ȥ��

            int l = i+1, r = nums.length-1;
            if(nums[l] < 0 && Integer.MIN_VALUE-nums[l] > nums[i]) continue; //��������Сֵ������
            if(nums[i] > 0 && Integer.MAX_VALUE-nums[l] < nums[i]) break; //������ֱֵ�ӽ����������ܻ����µ���Ԫ�������

            while(l < r){
                if(nums[r] > -nums[i]-nums[l]){
                    while(l < r && nums[r-1] == nums[r]) r--; //��ָ��ȥ��
                    r--;
                }
                else if(nums[r] < -nums[i]-nums[l]){
                    while(l < r && nums[l+1] == nums[l]) l++; //��ָ��ȥ��
                    l++;
                }
                else{
                    tuples.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l < r && nums[r-1] == nums[r]) r--; //��ָ��ȥ��
                    while(l < r && nums[l+1] == nums[l]) l++; //��ָ��ȥ��
                    r--;
                    l++;
                }
            }
        }
        return tuples;
    }
}
