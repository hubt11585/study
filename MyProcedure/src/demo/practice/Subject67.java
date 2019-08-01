package demo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 【程序67】
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Subject67 {
    public static void main(String[] args) {
        String s= "[]";
        System.out.println( new Subject67().isValid(s));
    }

    static Map<Character,Character> map = new HashMap<>();

    static {
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
    }

    /**
     * 后进先匹配原理
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        if(arr.length <= 0){
            return true;
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                list.add(arr[i]);
            }else{
                if(list.size() <= 0) {
                    return false;
                }
                if(map.get(list.get(list.size()-1)) == arr[i]){
                    list.remove(list.size()-1);
                }else{
                    return false;
                }
            }
        }
        if(list.size() == 0){
            return true;
        }else {
            return false;
        }
    }
}
