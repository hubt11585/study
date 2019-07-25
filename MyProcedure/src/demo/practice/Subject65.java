package demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ������n ������������nums��һ��Ŀ��ֵtarget���ж�nums���Ƿ�����ĸ�Ԫ�� a��b��c�� d��ʹ��a + b + c + d��ֵ��target��ȣ�
 * �ҳ��������������Ҳ��ظ�����Ԫ�顣
 */
public class Subject65 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(arr,0));
    }

    /**
     * 4����֮��
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int lenths = nums.length;
        if(lenths <= 3){
            return lists;
        }
        int min = nums[0];
        int max = nums[lenths-1];
        int min0 = nums[0] + nums[1];
        int max0 = nums[lenths-1]+nums[lenths-2];
        for (int i = 0; i < lenths; i++) {
            for (int j = i+1; j < lenths; j++) {
                int tmp1 = target - nums[i] - nums[j];
                if(tmp1 > max0){
                    continue;
                }
                if(tmp1 < min0){
                    break;
                }
                for (int k = j+1; k < lenths; k++) {
                    int tmp = target - nums[i] - nums[j] - nums[k];
                    if(tmp > max){
                        continue;
                    }
                    if(tmp < min){
                        break;
                    }
                    for (int l = k+1; l < lenths; l++) {
                        int tmp0 = nums[i] + nums[j] + nums[k] + nums[l];
                        if(target == tmp0){
                            List<Integer> list = new ArrayList<>();
                            list.add( nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            if(!lists.contains(list)){
                                lists.add(list);
                            }
                        }
                    }
                }
            }
        }
        return lists;
    }
}
