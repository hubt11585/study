package demo.practice;

import java.util.*;

/**
 * ����һ�����ظ�Ԫ�ص�����candidates��һ��Ŀ����target���ҳ�candidates�����п���ʹ���ֺ�Ϊtarget����ϡ�
 * candidates�е����ֿ����������ظ���ѡȡ��
 * ˵����
 * �������֣�����target��������������
 * �⼯���ܰ����ظ�����ϡ�
 */
public class Subject86 {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        List<List<Integer>> list = new Subject86().combinationSum(candidates,7);
        System.out.println(list);
    }

    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        if (residue == 0) {
            // Java �пɱ���������ô��ݣ������Ҫ����ǰ path ���ֵ��������
            res.add(new ArrayList<>(pre));
            return;
        }
        // �Ż���ӵĴ���2����ѭ����ʱ�����жϣ���������ϵͳջ�����
        // residue - candidates[i] ��ʾ��һ�ֵ�ʣ�࣬�����һ�ֵ�ʣ�඼С�� 0 ����û�б�Ҫ���к����ѭ����
        // ��һ�����ԭʼ���������������ǰ�ᣬ��Ϊ�����������ʣ�ֻ࣬��Խ��ԽС
        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            // ���ؼ�����ΪԪ�ؿ����ظ�ʹ�ã�����ݹ鴫����ȥ���� i ������ i + 1
            findCombinationSum(residue - candidates[i], i, pre);
            pre.pop();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // �Ż���ӵĴ���1���ȶ��������򣬿�����ǰ��ֹ�ж�
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }
}
