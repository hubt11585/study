package demo.practice;

import java.util.Scanner;

/**
 * ������26��
 * ��Ŀ�����������ڼ��ĵ�һ����ĸ���ж�һ�������ڼ��������һ����ĸһ����������жϵڶ�����ĸ��
 */
public class Subject26 {
    public static void main(String[] args) {
        System.out.println("��������������������ĸ����ڼ���ֻ��Ҫǰ������ĸ���ɣ���");
        Scanner scanner = new Scanner(System.in);
        String  scannerStr= scanner.next();
        //�ж���������ڼ�
        weekDay(scannerStr);
    }

    /**
     * �ж���������ڵ����ڼ�
     * @param scannerStr
     */
    private static void weekDay(String scannerStr) {
        char[] scannerArr = scannerStr.toCharArray();
        switch (scannerArr[0]){
            case 'M': System.out.println("�����������һ"); break;
            case 'T':
                switch (scannerArr[1]){
                    case 'U': System.out.println("����������ڶ�"); break;
                    case 'H': System.out.println("�������������"); break;
                    default:
                        System.out.println("������Ĳ������ڣ����������룺");
                        Scanner scanner = new Scanner(System.in);
                        scannerStr= scanner.next();
                        //�ж���������ڼ�
                        weekDay(scannerStr);
                } break;

            case 'W': System.out.println("�������������"); break;
            case 'F': System.out.println("�������������"); break;
            case 'S':
                switch (scannerArr[1]){
                    case 'A': System.out.println("�������������"); break;
                    case 'U': System.out.println("�������������"); break;
                    default:
                        System.out.println("������Ĳ������ڣ����������룺");
                        Scanner scanner = new Scanner(System.in);
                        scannerStr= scanner.next();
                        //�ж���������ڼ�
                        weekDay(scannerStr);
                }break;
            default:
                System.out.println("������Ĳ������ڣ����������룺");
                Scanner scanner = new Scanner(System.in);
                scannerStr= scanner.next();
                //�ж���������ڼ�
                weekDay(scannerStr);
        }
    }
}
