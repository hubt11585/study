package demo.practice;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * ������8��
 * ��Ŀ����s=a+aa+aaa+aaaa+aa��a��ֵ������a��һ�����֡�����2+22+222+2222+22222(��ʱ����5�������)������������м��̿��ơ�����������ʽ�磺2+22+222=246��
 */
public class Subject8 {
    public static void main(String[] args) {
        System.out.println("����������1(С��10)��" );
        Scanner scanner=new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println("����������2(1-10)��" );
        int b = scanner.nextInt();
        sum(a,b);
    }

    /**
     * ���
     * @param num1
     * @param num2
     */
    public static void sum(int num1,int num2) {
        String numStr = "";
        String result = "";
        BigDecimal bigDecimal = new BigDecimal("8");
        for(int i=1;i< num1; i++ ){
            numStr = numStr+num2;
            if(i==1){
                result = result+numStr;
            }else{
                result = result+"+"+numStr;
            }
            bigDecimal = bigDecimal.add(new BigDecimal(numStr));
        }
        result = result +"=" +bigDecimal.toString();
        System.out.println("�����"+result);
    }
}
