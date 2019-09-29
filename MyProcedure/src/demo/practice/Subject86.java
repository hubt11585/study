package demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 */
public class Subject86 {

    List<List<Integer>> resultList = null;

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        List<List<Integer>> list = new Subject86().combinationSum(candidates,7);
        System.out.println(list);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        resultList = new ArrayList<>();
        int arrLength = candidates.length;
        if(arrLength < 0){
            return null;
        }
        // 排除大于target 的数。
        Arrays.sort(candidates);
        List<List<Integer>> listTmp = new ArrayList<>();
        List<Integer> newList = new ArrayList();
        for (int i = 0; i < arrLength; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);
            if(candidates[i] < target){
                newList.add(candidates[i]);
                listTmp.add(list);
            }else if(candidates[i] == target){
                resultList.add(list);
                break;
            }else{
                break;
            }
        }

        this.getResultList(newList,target,listTmp);
        return resultList;
    }

    /**
     * target 减去整个数组，后结果大于0的保存下来，并且将小于0的数据都删除，知道newList数据为空。
     * @param newList
     * @param target
     * @param listTmp
     */
    public void getResultList(List<Integer> newList,int target,List<List<Integer>> listTmp) {
        if(newList.size() <= 0){
            return;
        }
        List<List<Integer>> listTmp0 =  new ArrayList<>();
        listTmp0.addAll(listTmp);
        listTmp.clear();
        int tmp0Sum = 0;
        if(listTmp0.size() > 0){
            tmp0Sum = sumList(listTmp0.get(0));
        }
        for (int i = 0; i < newList.size(); i++) {
            int newInt = newList.get(i);
            if(target - tmp0Sum - newInt < 0){
                newList.remove(i);
                i--;
                continue;
            }
            if(listTmp0.size() > 0) {
                for (int j = 0; j < listTmp0.size(); j++) {
                    int tmpSum = sumList(listTmp0.get(j));
                    int dValue = target - tmpSum - newInt;
                    if (dValue > 0) {
                        List<Integer> list = new ArrayList<>();
                        list.addAll(listTmp0.get(j));
                        list.add(newInt);
                        listTmp.add(list);
                    } else if (dValue == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.addAll(listTmp0.get(j));
                        list.add(newInt);
                        Collections.sort(list);
                        if(!resultList.contains(list)){
                            resultList.add(list);
                        }
                        listTmp.add(list);
                    }
                }
            }
        }
        getResultList(newList,target,listTmp);
    }

    public int sumList(List<Integer> integerList) {
        int sum = 0;
        for (int i = 0; i < integerList.size(); i++) {
            sum += integerList.get(i);
        }
        return sum;
    }
}
