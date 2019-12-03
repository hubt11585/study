package demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Subject96 {
    public static void main(String[] args) {
        String[] strArr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> listList = new Subject96().groupAnagrams(strArr);
        System.out.println(listList);
    }

    List<List<String>> listList = new ArrayList<>();
    Map<String,List<String>> map = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            String str = dealChar(ch);
            if(map.get(str) == null){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(str,list);
            }else{
                List<String> list = map.get(str);
                list.add(strs[i]);
            }
        }

        Iterator<Map.Entry<String, List<String>>> it=map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, List<String>> entry=it.next();
            listList.add(entry.getValue());
        }

        return listList;
    }

    public String dealChar(char[] ch) {
        String str = "";
        Arrays.sort(ch);
        return new String(ch,0,ch.length);
    }
}
