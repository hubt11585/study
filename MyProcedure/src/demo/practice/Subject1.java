package demo.practice;

import java.util.Scanner;

/**
 * ��Ŀ���ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�С���ӳ����������º�ÿ��������һ�����ӣ��������Ӷ���������ÿ���µ����Ӷ���Ϊ���٣�
 * ���� һ�� 1�ԣ� 2�� 1�ԣ�3�� 2�ԣ�4�� 3�ԣ�5��5�ԣ�6��8�ԣ�7��13�ԣ�8�� 21ֻ
 */
public class Subject1 {

    public static void main(String[] args) {
        System.out.print("����������֪���������������·ݣ�");

        Scanner scanner=new Scanner(System.in);

        int n=scanner.nextInt();//��ȡ���������

        System.out.println(test(n));

        System.out.println(fun(n));

        scanner.close();
    }

    /**
     * ����д��
     * @param i
     * @return
     */
    public static int test(int i){
        int tot = 0;
        int a = 0;
        int b = 1;
        for(int j = 0;j<i; j++){
            tot = a+b;
            a = b;
            b = tot;
        }
        return a;
    }

    /**
     * ����д��
     * @param
     * @return
     */
    private static int fun(int n){
        if(n==1 ||n==2)
            return 1;
        else
            return fun(n-1)+fun(n-2);
    }

}
