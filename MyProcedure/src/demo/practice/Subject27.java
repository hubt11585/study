package demo.practice;

import java.util.Scanner;

/**
 * ������27��
 * ��Ŀ����10������������
 */
public class Subject27 {

    public static void main(String[] args) {
        System.out.println("������10��������");
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[10];
        for (int i = 0; i <10 ; i++) {
            System.out.println("�������"+(i+1)+"����:");
            int num = scanner.nextInt();
            arr[i] = num;
        }

        sortInt(arr);
    }

    /**
     * ������arr��������
     * @param arr
     */
    private static void sortInt(int[] arr) {
        int tmp = 0;
        for(int i =0 ;i<arr.length;i++){
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i] > arr[j]){
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        System.out.println("��С��������Ϊ��");
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
