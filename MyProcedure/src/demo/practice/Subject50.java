package demo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 */
public class Subject50 {
    public static void main(String[] args) {
        String Str = "aabcdfffwwesdwhjkl";
        int count = lengthOfLongestSubstring(Str);
        System.out.println(count);
    }

    /**
     * 获取字符最大长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        List<Character> list = new ArrayList<>();
        int maxCount = 0;
        int count;
        for (int i = 0; i < arr.length; i++) {
            if(list.contains(arr[i])){
                count = list.size();
                if(count> maxCount){
                    maxCount = count;
                }
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j) != arr[i]){
                        list.remove(j);
                        j--;
                    }else{
                        list.remove(j);
                        break;
                    }
                }
                list.add(arr[i]);
            }else{
                list.add(arr[i]);
            }
        }
        if(list.size() > maxCount){
            return list.size();
        }else{
            return maxCount;
        }
    }
}
