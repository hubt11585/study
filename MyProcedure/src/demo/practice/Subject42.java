package demo.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ������42��
 * ��Ŀ������һ��ż�����жϸ�ż����������������֮�͡�
 */
public class Subject42 {
    public static void main(String[] args) {
        System.out.println("��������ڵ���2��ż����");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        getTwoPrimeNum(num);
    }

    /**
     * ��ȡ��������
     * @param num
     */
    private static void getTwoPrimeNum(int num) {
        List<Integer> primeNumberList = getPrimeNumber(2,num);
        for (int i = 0; i < primeNumberList.size(); i++) {
            for (int j = i; j < primeNumberList.size(); j++) {
                if(num == primeNumberList.get(i) + primeNumberList.get(j)){
                    System.out.println("��ż��Ϊ������"+primeNumberList.get(i)+"����������"+primeNumberList.get(j)+"���ĺ�");
                }
            }
        }
    }

    /**
     * �ж�a��b֮���ж��ٸ�����
     * @param a
     * @param b
     */
    public static List<Integer> getPrimeNumber(int a, int b){
        List<Integer> primeNumberList = new ArrayList<>();
        if(a >= b){
            System.out.println("a���ܴ��ڵ���b��");
        }
        for(int i=a;i<=b;i++){
            if(isPrimeNumber(i)){
                primeNumberList.add(i);
            }
        }
        return primeNumberList;
    }

    /**
     * �ж�num�Ƿ���һ������
     * @param i
     * @return
     */
    private static boolean isPrimeNumber(int i) {
        boolean flag = true;
        for(int j=2;j <= i/2;j++){
            if(i%j == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
