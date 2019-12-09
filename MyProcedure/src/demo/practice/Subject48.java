package demo.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * ������48��
 * ����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±�
 */
public class Subject48 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,5,6,7,9,76,43,22,11};
        int target = 11;
        int[] result = twoSum(nums,target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * ��ȡ���������������±�
     * @param nums
     * @param target
     */
    private static int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        //��������
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            //�жϼ�ֵ�Ƿ����
            if(map.containsKey(target - a)){
                temp[0] = map.get(target - a);
                temp[1] = i;
                return temp;
            }else {//����Ҳ�������ȥ
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
