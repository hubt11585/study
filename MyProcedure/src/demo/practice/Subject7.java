package demo.practice;

import java.util.Scanner;

/**
 * 【程序7】
 * 题目：输入一行字符，分别统计出其英文字母、空格、数字和其它字符的个数。
 */
public class Subject7 {
    public static void main(String[] args) {
        System.out.println("请出入字符串：" );
        Scanner scanner=new Scanner(System.in);
        scanner.useDelimiter("\n");
        String tmpStr = scanner.next();
        classify(tmpStr);
    }

    public static void classify(String str){
        char[] strArr = str.toCharArray();
        int num1 = 0;  //字母
        String num1Str = "";
        int num2 = 0;  //数字
        String num2Str = "";
        int space = 0; //空格
        String spaceStr = "";
        int other = 0; //其他
        String otherStr = "";
        for (int i = 0; i < strArr.length ; i++) {
            int ascii = (int)strArr[i];
            if( 48<= ascii && ascii <= 59){
                num2 = num2 + 1;
                num2Str = num2Str +strArr[i] +" ";
            }else if(ascii == 32){
                space = space +1;
            }else if((65<= ascii && ascii <= 90) || (97 <= ascii && ascii <=  122)){
                num1 = num1 + 1;
                num1Str = num1Str +strArr[i] +" ";
            }else{
                other = other + 1;
                otherStr = otherStr +strArr[i] +" ";
            }
        }
        System.out.println("存在字母个数:" + num1);
        System.out.println("存在字母如下:" + num1Str);

        System.out.println("存在数字个数:" + num2);
        System.out.println("存在数字如下:" + num2Str);

        System.out.println("存在空格个数:" + space);

        System.out.println("存在其他个数:" + other);
        System.out.println("存在其他如下:" + otherStr);

    }
}
