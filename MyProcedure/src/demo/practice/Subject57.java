package demo.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ���ַ��� s ��һ���ַ����� p��������ʵ��һ��֧�� '.' �� '*' ��������ʽƥ�䡣
 * '.' ƥ�����ⵥ���ַ�
 * '*' ƥ���������ǰ�����һ��Ԫ��
 */
public class Subject57 {
    public static void main(String[] args) {
        Map<String ,String>  map = new HashMap<>();
        map.put("dddc","d*dddc");    //true;
        for (Map.Entry<String,String> entry :map.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
            System.out.println(isMatch(entry.getKey(),entry.getValue()));
        }
    }

    /**
     * ʵ��ƥ�����
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
