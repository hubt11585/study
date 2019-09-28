package demo.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ����һ�����ظ�Ԫ�ص�����candidates��һ��Ŀ����target���ҳ�candidates�����п���ʹ���ֺ�Ϊtarget����ϡ�
 * candidates�е����ֿ����������ظ���ѡȡ��
 * ˵����
 * �������֣�����target��������������
 * �⼯���ܰ����ظ�����ϡ�
 */
public class Subject86 {

    List<List<Integer>> resultList = null;

    public static void main(String[] args) {
        int[] candidates = new int[]{1};
        List<List<Integer>> list = new Subject86().combinationSum(candidates,1);
        System.out.println(list);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        resultList = new ArrayList<>();
        int arrLength = candidates.length;
        if(arrLength < 0){
            return null;
        }
        // �ų�����target ������

        List<Integer> newList = new ArrayList();
        for (int i = 0; i < arrLength; i++) {
            if(candidates[i] <= target){
                newList.add(candidates[i]);
            }
        }
        Collections.sort(newList);

        List<List<Integer>> listTmp = new ArrayList<>();
        this.getResultList(newList,target,listTmp);
        return resultList;
    }

    /**
     * target ��ȥ�������飬��������0�ı������������ҽ�С��0�����ݶ�ɾ����֪��newList����Ϊ�ա�
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
            if(target - tmp0Sum - newList.get(i) < 0){
                newList.remove(i);
                i--;
                continue;
            }
            if(listTmp0.size() > 0) {
                for (int j = 0; j < listTmp0.size(); j++) {
                    int tmpSum = sumList(listTmp0.get(j));
                    int dValue = target - tmpSum - newList.get(i);
                    if (dValue > 0) {
                        List<Integer> list = new ArrayList<>();
                        list.addAll(listTmp0.get(j));
                        list.add(newList.get(i));
                        listTmp.add(list);
                    } else if (dValue == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.addAll(listTmp0.get(j));
                        list.add(newList.get(i));
                        Collections.sort(list);
                        if(!resultList.contains(list)){
                            resultList.add(list);
                        }
                        listTmp.add(list);
                    }
                }
            }else{
                int dValue = target - newList.get(i);
                if(dValue > 0){
                    List<Integer> list = new ArrayList<>();
                    list.add( newList.get(i));
                    listTmp.add(list);
                }else if(dValue == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add( newList.get(i));
                    resultList.add(list);
                    listTmp.add(list);
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