package demo.practice;

import java.util.Scanner;

/**
 * ������37��
 * ��Ŀ����дһ������������nΪż��ʱ�����ú�����1/2+1/4+��+1/n,������nΪ����ʱ�����ú���1/1+1/3+��+1/n
 */
public class Subject37 {

    private static double sum = 0;    //���

    private static String str = "";   //ƴ���ַ���

    public static void main(String[] args) {
        System.out.println("������һ����������");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        specialDeal(num);
        System.out.print(str.substring(0,str.length()-2)+"�ĺ�Ϊ��");
        System.out.println(sum);
    }

    /**
     * ����nΪż��ʱ�����ú�����1/2+1/4+��+1/n,������nΪ����ʱ�����ú���1/1+1/3+��+1/n
     * @param num
     */
    private static void specialDeal(int num) {
        sum = sum+ 1.0/num;
        if(num > 2){
            specialDeal(num-2);
        }
        str = str+"1/"+num+" + ";
    }
}
