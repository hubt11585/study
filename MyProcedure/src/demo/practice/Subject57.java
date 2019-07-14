package demo.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 */
public class Subject57 {
    public static void main(String[] args) {
        Map<String ,String>  map = new HashMap<>();
        /*map.put("aab","c*a*b");    //true;
        map.put("aaba","ab*a*c*a");  //false;
        map.put("aaca","ab*a*c*a");  //true;

        map.put("a",".*..a*");      //false;

        map.put("cc","c");      //false;
        map.put("dd","ddc*d*f*");      //true;

        map.put("mississippi","mis*is*p*.");      //false;
        map.put("bb","bbc");      //false;
        map.put("baa",".bbc");      //false;
        map.put("aa","a*");         //true;

        map.put("ddd","d*ddd");    //true;
        map.put("fff","f*f");    //true;
        map.put("aaa","ab*ac*a");      //true;
        map.put("bbbba",".*a*a");      //true;*/
        map.put("dddc","d*dddc");    //true;
        for (Map.Entry<String,String> entry :map.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
            System.out.println(isMatch(entry.getKey(),entry.getValue()));
        }
    }

    /**
     * 实现匹配规则
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}
