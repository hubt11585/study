package demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * ����һ������candidates��һ��Ŀ����target���ҳ�candidates�����п���ʹ���ֺ�Ϊtarget����ϡ�
 * candidates�е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�
 * ˵����
 * �������֣�����Ŀ������������������
 * �⼯���ܰ����ظ�����ϡ�
 */
public class Subject87 {

    private List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> list = new Subject87().combinationSum2(candidates,7);
        System.out.println(list);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // �Ż���ӵĴ���1���ȶ��������򣬿�����ǰ��ֹ�ж�
        Arrays.sort(candidates);
        findCombinationSum(target, 0, new Stack<>(),candidates);
        return res;
    }

    private void findCombinationSum(int residue, int start, Stack<Integer> pre, int[] candidates) {
        if (residue == 0) {
            // Java �пɱ���������ô��ݣ������Ҫ����ǰ path ���ֵ��������
            List list= new ArrayList<>(pre);
            res.add(list);
            return;
        }
        // �Ż���ӵĴ���2����ѭ����ʱ�����жϣ���������ϵͳջ�����
        // residue - candidates[i] ��ʾ��һ�ֵ�ʣ�࣬�����һ�ֵ�ʣ�඼С�� 0 ����û�б�Ҫ���к����ѭ����
        // ��һ�����ԭʼ���������������ǰ�ᣬ��Ϊ�����������ʣ�ֻ࣬��Խ��ԽС
        for (int i = start; i < candidates.length && residue - candidates[i] >= 0; i++) {
            if( i-1 >= 0 && candidates[i] == candidates[i-1]){
                continue;
            }
            pre.add(candidates[i]);
            // ���ؼ�����ΪԪ�ؿ����ظ�ʹ�ã�����ݹ鴫����ȥ���� i ������ i + 1
            findCombinationSum(residue - candidates[i], i, pre,this.copyArr2(candidates,i));
            pre.pop();
        }
    }

    public int[] copyArr2(int[] candidatesTmp,int index){
        int[] candidates = new int[candidatesTmp.length-1];
        for (int i = 0,j = 0; i < candidatesTmp.length; i++) {
            if(index == i){
               continue;
            }else{
                candidates[j++] = candidatesTmp[i];
            }
        }
        return candidates;
    }
}
