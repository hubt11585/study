package demo.practice;

import java.util.Scanner;

/**
 * ������45��
 * ��Ŀ����ȡ7������1��50��������ֵ��ÿ��ȡһ��ֵ�������ӡ����ֵ�����ģ���
 */
public class Subject45 {
    public static void main(String[] args) {
        System.out.println("������һ����1��50����������");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        printSymbol(num);
    }

    /**
     * ��ӡ���š�����
     * @param num
     */
    private static void printSymbol(int num) {
        for (int i = 0; i < num ; i++) {
            System.out.print("��");
        }
    }
}
