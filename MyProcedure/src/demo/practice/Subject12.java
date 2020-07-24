package demo.practice;

import java.util.Scanner;

/**
 * ������12��
 * ��Ŀ����ҵ���ŵĽ������������ɡ�����(I)���ڻ����10��Ԫʱ���������10%���������10��Ԫ������20��Ԫʱ��
 * ����10��Ԫ�Ĳ��ְ�10%��ɣ�����10��Ԫ�Ĳ��֣��ɿ����7.5%��20��40��֮��ʱ������20��Ԫ�Ĳ��֣������5%��
 * 40��60��֮��ʱ����40��Ԫ�Ĳ��֣������3%��60��100��֮��ʱ������60��Ԫ�Ĳ��֣������1.5%��
 * ����100��Ԫʱ������100��Ԫ�Ĳ��ְ�1%��ɣ��Ӽ������뵱������I����Ӧ���Ž���������
 */
public class Subject12 {

    public static void main(String[] args) {
        System.out.println("����������ҵ����");
        Scanner scanner = new Scanner(System.in);
        double profit= scanner.nextDouble();
        System.out.println("���õ������Ϊ��"+premium(profit));
    }

    public static double premium(double profit){
        double premium = 0;
        if(profit <= 100000){
            premium = profit*0.1;
        }else if(profit > 100000 && profit <= 200000){
            premium = (profit - 100000) * 0.075 + premium(100000);
        }else if(profit > 200000 && profit <= 400000){
            premium = (profit - 200000) * 0.05 + premium(200000);
        }else if(profit > 400000 && profit <= 600000){
            premium = (profit - 400000) * 0.03 + premium(400000);
        }else if(profit > 600000 && profit <= 1000000){
            premium = (profit - 600000) * 0.015 + premium(600000);
        }else{
            premium = (profit - 1000000) * 0.01 + premium(1000000);
        }
        return premium;
    }
}
