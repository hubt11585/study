package demo.practice;

import java.util.Scanner;

/**
 * ������43��
 * ��Ŀ���ж�һ�������ܱ�����9���� ������3�ܱ�9������ 9����3������3.�� ����ע ����ѧ���Ǻ����������ǰ�����
 * ������ˣ����⻹�Ǹо�û�����塣
 */
public class Subject43 {
    public static void main(String[] args) {
        System.out.println("������һ������");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        dealNum(num);
    }

    private static void dealNum(int num) {
        if(!isPrimeNumber(num)){
            System.out.println("����������ֲ���������");
            return ;
        }

        int divisorNum = 9;
        while(true){
            if(divisorNum%num == 0 ){
                System.out.println("������������ܱ�"+divisorNum/9+"��9������");
                break;
            }
            divisorNum = divisorNum + 9;
        }
    }

    /**
     * �ж�num�Ƿ���һ������
     * @param i
     * @return
     */
    private static boolean isPrimeNumber(int i) {
        boolean flag = true;
        for(int j=2;j <= i/2;j++){
            if(i%j == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
