package demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
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
        // 优化添加的代码1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        findCombinationSum(target, 0, new Stack<>(),candidates);
        return res;
    }

    private void findCombinationSum(int residue, int start, Stack<Integer> pre, int[] candidates) {
        if (residue == 0) {
            // Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
            List list= new ArrayList<>(pre);
            res.add(list);
            return;
        }
        // 优化添加的代码2：在循环的时候做判断，尽量避免系统栈的深度
        // residue - candidates[i] 表示下一轮的剩余，如果下一轮的剩余都小于 0 ，就没有必要进行后面的循环了
        // 这一点基于原始数组是排序数组的前提，因为如果计算后面的剩余，只会越来越小
        for (int i = start; i < candidates.length && residue - candidates[i] >= 0; i++) {
            if( i-1 >= 0 && candidates[i] == candidates[i-1]){
                continue;
            }
            pre.add(candidates[i]);
            // 【关键】因为元素可以重复使用，这里递归传递下去的是 i 而不是 i + 1
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
