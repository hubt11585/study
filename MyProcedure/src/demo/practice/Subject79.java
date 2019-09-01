package demo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class Subject79 {

    public static void main(String[] args) {

        System.out.println(new Subject79().longestValidParentheses("(()()()(()))))))"));
    }

    public int longestValidParentheses(String s) {
        int lengths = s.length();
        if(lengths <= 0){
            return 0;
        }
        char[] arr = s.toCharArray();

        List<Integer> list = new ArrayList<>();

        /**
         * 将不可以匹配的括号留下，并且记录位置。
         */
        for (int i = 0; i < arr.length; i++) {
            if('(' == arr[i]){
                list.add(i);
            }else{
                int size = list.size();
                if(')' == arr[i] && list.size() > 0 && '(' == arr[list.get(size-1)]){
                    list.remove(size-1);
                }else{
                    list.add(i);
                }
            }
        }

        //获取最大间隔时间
        int maxLength = 0;
        for (int i = 0; i < list.size() ; i++) {
            if( i == 0 ){
                maxLength = list.get(i);
            }else {
                int tmp = list.get(i) - list.get(i-1) -1;
                if(tmp > maxLength){
                    maxLength = tmp;
                }
            }
        }

        if(list.size() > 0){
            int endLength = lengths - list.get(list.size()-1) -1;
            if(endLength > maxLength){
                maxLength = endLength;
            }
        } else {
            maxLength = lengths;
        }

        return maxLength;
    }
}
