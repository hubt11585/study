package demo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ������67��
 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']'���ַ������ж��ַ����Ƿ���Ч��
 * ��Ч�ַ��������㣺
 * �����ű�������ͬ���͵������űպϡ�
 * �����ű�������ȷ��˳��պϡ�
 * ע����ַ����ɱ���Ϊ����Ч�ַ�����
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
     * �����ƥ��ԭ��
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
