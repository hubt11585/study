package demo.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * ������52��
 * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
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
