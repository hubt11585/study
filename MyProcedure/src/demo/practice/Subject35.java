package demo.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ������35��
 * ��Ŀ����n����Χ��һȦ��˳���źš��ӵ�һ���˿�ʼ��������1��3��������������3�����˳�Ȧ�ӣ���������µ���ԭ���ڼ��ŵ���λ
 */
public class Subject35 {
    public static void main(String[] args) {
        System.out.println("������������");
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        System.out.println( numberGame(n));
        numberGame1(n);
    }

    private static void numberGame1(int n) {
        List<Integer> list = new ArrayList<>();
        /****************��50���˱��******************/
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        endGameByNum(list,1);
    }

    /**
     * ������Ϸ
     * @param n
     */
    private static int numberGame(int n) {
        return n == 1 ? n : (numberGame(n - 1) + 3 - 1) % n + 1;
    }

    /**
     * ��ȡ������µ���
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
                System.out.println("������µ���Ϊ"+list.get(i)+"��ѡ�֣�");
            }
        }
    }
}
