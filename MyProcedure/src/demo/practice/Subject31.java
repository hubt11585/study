package demo.practice;

import java.util.Scanner;

/**
 * ������31��
 * ��Ŀ��ȡһ������a���Ҷ˿�ʼ��4��7λ��
 */
public class Subject31 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("������һ������8λ������");
        String num = scanner.next();
        intercept(num);
    }

    /**
     * ��ȡnum
     * @param num
     */
    private static void intercept(String num) {
        char[] arr = num.toCharArray();
        int j=0;
        System.out.print("��ȡ���Ϊ��");
        for(int i = arr.length-1 ; i >= 0;i--){
            j++;
            if(j >= 4 && j<=7){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
