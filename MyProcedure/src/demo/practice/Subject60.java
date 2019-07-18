package demo.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * ������60��
 * ��������ת���������֣��������ְ������������ַ��� I�� V�� X�� L��C��D �� M��
 */
public class Subject60 {
    public static void main(String[] args) {
        System.out.println(new Subject60().romanToInt("MCMXCIV"));
    }

    static Map<String,Integer> map = new HashMap<>();

    /**
     * ��̬������������
     */
    static {
        map.put("I",1);
        map.put("II",2);
        map.put("III",3);
        map.put("IV",4);
        map.put("V",5);
        map.put("VI",6);
        map.put("VII",7);
        map.put("VIII",8);
        map.put("IX",9);
        map.put("X",10);
        map.put("XX",20);
        map.put("XXX",30);
        map.put("XL",40);
        map.put("L",50);
        map.put("LX",60);
        map.put("LXX",70);
        map.put("LXXX",80);
        map.put("XC",90);
        map.put("C",100);
        map.put("CC",200);
        map.put("CCC",300);
        map.put("CD",400);
        map.put("D",500);
        map.put("DC",600);
        map.put("DCC",700);
        map.put("DCCC",800);
        map.put("CM",900);
        map.put("M",1000);
        map.put("MM",2000);
        map.put("MMM",3000);
    }

    /**
     * ��������ת����������
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        // I X C M �ֱ����1��10��100��1000
        int result = 0;
        char[] arr = s.toCharArray();
        int lenth = arr.length;

        String tmp = "";
        int index0 = 0;
        for (int i = 0; i < lenth ;) {
            tmp = tmp + arr[i];
            if(map.containsKey(tmp)){
                index0 = map.get(tmp);
                i++;
            }else{
                result = result +index0;
                tmp = "";
                index0 = 0;
            }
        }
        return result+index0;
    }
}
