package demo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 * ��ע��ÿ�����ֶ�Ӧ����ĸΪ9�������뷨��
 */
public class Subject64 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static Map<Character,List<Character>> map = new HashMap<>();
    //��ʼ������
    static {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        map.put('2',list);
        list = new ArrayList<>();
        list.add('d');
        list.add('e');
        list.add('f');
        map.put('3',list);
        list = new ArrayList<>();
        list.add('g');
        list.add('h');
        list.add('i');
        map.put('4',list);
        list = new ArrayList<>();
        list.add('j');
        list.add('k');
        list.add('l');
        map.put('5',list);
        list = new ArrayList<>();
        list.add('m');
        list.add('n');
        list.add('o');
        map.put('6',list);
        list = new ArrayList<>();
        list.add('p');
        list.add('q');
        list.add('r');
        list.add('s');
        map.put('7',list);
        list = new ArrayList<>();
        list.add('t');
        list.add('u');
        list.add('v');
        map.put('8',list);
        list = new ArrayList<>();
        list.add('w');
        list.add('x');
        list.add('y');
        list.add('z');
        map.put('9',list);
    }

    public static List<String> list;

    /**
     * ����������
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return list;
        }
        list = new ArrayList<>();
        list.add("");
        char[] arr = digits.toCharArray();
        for (int i = 0; i < arr.length ; i++) {
            letterCombinations0(arr[i]);
        }
        return list;
    }

    /**
     * ���letterCombinationsʹ��
     * @param c
     */
    public static void letterCombinations0(char c){
        List<Character> list0  = map.get(c);
        List<String> listTmp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list0.size(); j++) {
                listTmp.add(list.get(i)+list0.get(j));
            }
        }
        list = listTmp;
    }
}
