package demo.practice;

import java.util.Scanner;

/**
 * ������24��
 * ��Ŀ����һ��������5λ����������Ҫ��һ�������Ǽ�λ�������������ӡ����λ���֡�
 */
public class Subject24 {

    public static void main(String[] args) {
        System.out.println("��������Ҫ��������������");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        analysisInt(num);
    }

    /**
     * ����������
     * @param num
     */
    private static void analysisInt(int num) {
        String tmpStr = String.valueOf(num);
        char[] arrStr =tmpStr.toCharArray();
        System.out.println("����������"+arrStr.length+"λ����");
        System.out.println("�����ӡΪ��");
        for (int i = arrStr.length-1; i >= 0; i--) {
            System.out.print(arrStr[i]+" ");
        }
    }
}
