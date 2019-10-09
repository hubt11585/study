package demo.practice;

import java.util.Scanner;

/**
 * ??????7??
 * ????????????????????????????????????????????????????????
 */
public class Subject7 {
    public static void main(String[] args) {
        System.out.println("?????????????" );
        Scanner scanner=new Scanner(System.in);
        scanner.useDelimiter("\n");
        String tmpStr = scanner.next();
        classify(tmpStr);
    }

    public static void classify(String str){
        char[] strArr = str.toCharArray();
        int num1 = 0;  //???
        String num1Str = "";
        int num2 = 0;  //????
        String num2Str = "";
        int space = 0; //???
        String spaceStr = "";
        int other = 0; //????
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
        System.out.println("???????????:" + num1);
        System.out.println("???????????:" + num1Str);

        System.out.println("???????????:" + num2);
        System.out.println("????????????:" + num2Str);

        System.out.println("?????????:" + space);

        System.out.println("????????????:" + other);
        System.out.println("????????????:" + otherStr);

    }
}
