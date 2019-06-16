package demo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 【程序25】
 * 题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
 */
public class Subject25 {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int num = 12321;
        palindromeNumber(num);
        if(list.get(0) == list.get(4) && list.get(1) == list.get(3)){
            System.out.println("数字（"+num+")是回文数");
        }else{
            System.out.println("数字（"+num+")不是回文数");
        }

        /***第二种方式**/
        char[] arr = (num+"").toCharArray();
        if(arr[0]==arr[4] && arr[1]==arr[3]){
            System.out.println("数字（"+num+")是回文数");
        }else{
            System.out.println("数字（"+num+")不是回文数");
        }
    }

    /**
     * 判断num是否是回文数
     * @param num
     */
    private static void palindromeNumber(int num) {
        int lenght =  (num+"").length()-1;
        int numTmp = 0;
        if(num < 10){
            numTmp =num;
        }else{
            numTmp = num/(int)Math.pow(10,lenght);
            int tmp =num - numTmp*(int)Math.pow(10,lenght);
            palindromeNumber(tmp);
        }
        list.add(numTmp);
    }
}
