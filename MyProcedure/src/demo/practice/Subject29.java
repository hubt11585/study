package demo.practice;

import java.util.Scanner;

/**
 * ������29��
 * ��Ŀ����һ���Ѿ��ź�������顣������һ������Ҫ��ԭ���Ĺ��ɽ������������С�
 */
public class Subject29 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,0};
        System.out.println("������һ��1��8֮�������");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for (int i = 0; i < arr.length-2 ; i++) {
            if(num >= arr[i] && num <= arr[i+1] ){
                for (int j = arr.length-1; j > i+1 ; j--) {
                    arr[j] = arr[j-1];
                }
                arr[i+1] = num;
                break;
            }
        }
        System.out.print("��������("+num+")֮�������Ϊ��");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
