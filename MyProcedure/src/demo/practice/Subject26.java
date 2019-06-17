package demo.practice;

import java.util.Scanner;

/**
 * 【程序26】
 * 题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续判断第二个字母。
 */
public class Subject26 {
    public static void main(String[] args) {
        System.out.println("请输入你现在心里想的哪个星期几（只需要前两个字母即可）：");
        Scanner scanner = new Scanner(System.in);
        String  scannerStr= scanner.next();
        //判断输入的星期几
        weekDay(scannerStr);
    }

    /**
     * 判断输入的星期的星期几
     * @param scannerStr
     */
    private static void weekDay(String scannerStr) {
        char[] scannerArr = scannerStr.toCharArray();
        switch (scannerArr[0]){
            case 'M': System.out.println("您输入的星期一"); break;
            case 'T':
                switch (scannerArr[1]){
                    case 'U': System.out.println("您输入的星期二"); break;
                    case 'H': System.out.println("您输入的星期四"); break;
                    default:
                        System.out.println("您输入的不是星期，请重新输入：");
                        Scanner scanner = new Scanner(System.in);
                        scannerStr= scanner.next();
                        //判断输入的星期几
                        weekDay(scannerStr);
                } break;

            case 'W': System.out.println("您输入的星期三"); break;
            case 'F': System.out.println("您输入的星期五"); break;
            case 'S':
                switch (scannerArr[1]){
                    case 'A': System.out.println("您输入的星期六"); break;
                    case 'U': System.out.println("您输入的星期天"); break;
                    default:
                        System.out.println("您输入的不是星期，请重新输入：");
                        Scanner scanner = new Scanner(System.in);
                        scannerStr= scanner.next();
                        //判断输入的星期几
                        weekDay(scannerStr);
                }break;
            default:
                System.out.println("您输入的不是星期，请重新输入：");
                Scanner scanner = new Scanner(System.in);
                scannerStr= scanner.next();
                //判断输入的星期几
                weekDay(scannerStr);
        }
    }
}
