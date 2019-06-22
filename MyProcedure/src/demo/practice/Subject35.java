package demo.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 【程序35】
 * 题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位
 */
public class Subject35 {
    public static void main(String[] args) {
        System.out.println("请输入人数：");
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        numberGame(n);
    }

    /**
     * 数字游戏
     * @param n
     */
    private static void numberGame(int n) {
        List<Integer> list = new ArrayList<>();
        /****************给50个人编号******************/
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        endGameByNum(list,1);
    }

    /**
     * 获取最后留下的人
     * @param list
     * @param ident
     */
    private static void endGameByNum(List<Integer> list,int ident) {
        List<Integer> listTmp = new ArrayList<>();

        if(list.size() >=  3 ) {
            for (int i = 0; i < list.size(); i++) {
                if ((i+ident)%3 != 0) {
                    listTmp.add(list.get(i));
                }
            }
            endGameByNum(listTmp,list.size()%3+1);
        }else{
            for (int i = 0; i < list.size(); i++) {
                System.out.println("最后留下的人为"+list.get(i)+"号选手！");
            }
        }
    }
}
