package demo.practice;

import java.util.Scanner;

/**
 * ������46��
 * ��Ŀ��ĳ����˾���ù��õ绰�������ݣ���������λ���������ڴ��ݹ������Ǽ��ܵģ����ܹ������£�ÿλ���ֶ�����5,Ȼ���úͳ���10��������������֣��ٽ���һλ�͵���λ�������ڶ�λ�͵���λ������
 */
public class Subject46 {
    public static void main(String[] args) {
        System.out.println("������һ��4λ������");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        encryption(num);
    }

    /**
     * ���ּ���
     * @param num
     */
    private static void encryption(int num) {
        char[] arr= (num+"").toCharArray();
        for (int i = 0; i < arr.length/2; i++) {
            char tmp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = tmp;
        }
        String cipherText = "";
        for (int i = 0; i < arr.length; i++) {
            int tmp = (arr[i]-'0'+5)%10;
            cipherText = cipherText+tmp;
        }
        System.out.println("���ģ�"+cipherText);
    }
}
