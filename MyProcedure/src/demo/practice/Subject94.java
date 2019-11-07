package demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����һ���ɰ����ظ����ֵ����У��������в��ظ���ȫ���С�
 */
public class Subject94 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{3,1,3,3};
        List<List<Integer>> integerList1 = new Subject94().permuteUnique(arrInt);
        System.out.println(integerList1);
    }

    List<List<Integer>> integerList = new ArrayList<>();
    List<Integer> integerListTmp = new ArrayList<>();

    int index = -1;

    /**
     * ʹ�������
     * ��֦�ķ�ʽʵ�֡�
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        //����
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
            integerListTmp.add(nums[i]);
        }
        index = nums.length;
        permuteUnique(numList);
        return integerList;
    }

    public void permuteUnique(List<Integer> numList) {
        int sizes = numList.size();
        if (sizes <= 0) {
            return ;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < sizes; i++) {
            Integer integer = map.get(index- sizes);
            if(integer != null){
                if(integer == numList.get(i)){  //����ķ�֧������
                    continue;
                }else{
                    map.put(index- sizes,numList.get(i));
                }
            }else{
                map.put(index- sizes,numList.get(i));
            }

            if(integerListTmp.get(index- sizes) != numList.get(i)){
                integerListTmp.set(index- sizes,numList.get(i));
            }
            if(sizes <= 1){
                List<Integer> numListTmp0 = new ArrayList<>();
                numListTmp0.addAll(integerListTmp);
                integerList.add(numListTmp0);
                return;
            }
            List<Integer> numListTmp = new ArrayList<>();
            numListTmp.addAll(numList);
            numListTmp.remove(i);
            permuteUnique(numListTmp);
        }
    }
}
