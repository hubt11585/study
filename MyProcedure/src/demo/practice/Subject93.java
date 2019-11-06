package demo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class Subject93 {
    public static void main(String[] args) {
        int[] arrInt = new int[]{1,2,3};
        List<List<Integer>> integerList1 = new Subject93().permute(arrInt);
        System.out.println(integerList1);
    }

    List<List<Integer>> integerList = new ArrayList<>();
    List<Integer> integerListTmp = new ArrayList<>();

    int index = -1;

    /**
     * 就一步步实现呗
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
            integerListTmp.add(nums[i]);
        }
        index = nums.length;
        permute(numList);
        return integerList;
    }

    public void permute(List<Integer> numList) {
        int sizes = numList.size();
        if (sizes <= 0) {
            return ;
        }
        for (int i = 0; i < sizes; i++) {
            integerListTmp.set(index- sizes,numList.get(i));
            if(sizes <= 1){
                List<Integer> numListTmp0 = new ArrayList<>();
                numListTmp0.addAll(integerListTmp);
                integerList.add(numListTmp0);
                return;
            }
            List<Integer> numListTmp = new ArrayList<>();
            numListTmp.addAll(numList);
            numListTmp.remove(i);
            permute(numListTmp);
        }
    }
}
