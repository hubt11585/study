package demo.practice;

import java.util.Scanner;

/**
 * ������10��
 * ��Ŀ��һ���100�׸߶��������£�ÿ����غ�����ԭ�߶ȵ�һ�룻n����ؾ���·���ܳ��Ⱥ��´η����ĸ߶ȡ�
 */
public class Subject10 {

    public static void main(String[] args) {
        System.out.println("��ѡ��ڼ�����أ�");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        sumLength(n);
    }

    public static void sumLength(int n){
        double height = 100;
        double sumLength = 100;
        for(int i=1; i<=n; i++){
            sumLength = sumLength + height;
            height = height/2;
        }
        System.out.println("���˶�����Ϊ��"+sumLength);
        System.out.println("���˶�����Ϊ��"+height);
    }
}
