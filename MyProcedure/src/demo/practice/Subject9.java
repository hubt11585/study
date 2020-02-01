package demo.practice;

import java.util.ArrayList;
        import java.util.List;

/***
 * 【程序9】
 * 题目：一个数如果恰好等于它的因子之和，这个数就称为”完数”。例如6=1＋2＋3.编程找出1000以内的所有完数。
 */
public class Subject9 {
    public static void main(String[] args) {
        for (int i = 0; i <1000 ; i++) {
            perfectNum(i);
        }
    }

    /**
     * 判断是否是完数
     */
    public static void perfectNum(int num){
        List<Integer> list = decompose(num);
        int sum = 0;
        for(int i :list){
            sum = sum + i;
        }
        if(num == sum && num != 1){
            System.out.println("完数："+num);
        }
    }

    /**
     * 分解质因数
     * @param num
     * @return
     */
    public static List decompose(int num){
        List<Integer> list = new ArrayList();
        list.add(1);
        int tmp = num/2;
        for(int i=2;i <= tmp ;i++){
            if(num%i == 0){
                list.add(i);
                continue;
            }
        }
        return list;
    }
}
