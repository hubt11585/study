package demo.practice;

import java.util.Scanner;

/**
 * ������36��
 * ��Ŀ��дһ����������һ���ַ����ĳ��ȣ���main�����������ַ�����������䳤�ȡ�
 */
public class Subject36 {

    public static void main(String[] args) {
        System.out.println("������һ���ַ�����");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        stringLength(str);
    }

    /**
     * ����ַ�������
     * @param str
     */
    private static void stringLength(String str) {
        char[] arr = str.toCharArray();
        System.out.println("�ַ������ȣ�"+ arr.length);
    }
}
