package demo.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 【程序52】
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class Subject52 {
    public static void main(String[] args) {
        String str = "babad";
        String result= longestPalindrome(str);
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
        String result = "";
        char[] arr = s.toCharArray();
        Map<Integer,Character> map = new HashMap<>();
        for(int i = 0 ; i< arr.length; i++){
            map.put(i,arr[i]);
        }
        for(){

        }
        return result;
    }
}
