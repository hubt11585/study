package demo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 【程序18】
 * 题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。有人向队员打听比赛的名单。
 * a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
 *
 * 除了题目本身还扩展实现了，总共可以出现多少种组合
 */
public class Subject18 {
    public static void main(String[] args) {

        List<Map> list = new ArrayList<>();
        Map<Character, Character> map = new HashMap<>();
        List<Character> a = new ArrayList<>();
        a.add('a');
        a.add('b');
        a.add('c');
        List<Character> b = new ArrayList<>();
        b.add('x');
        b.add('y');
        b.add('z');

        group(a,b,map,list);

        for(Map<Character, Character> maptmp:list){
            boolean flag = true;
            for (Map.Entry<Character, Character> entry : maptmp.entrySet()) {
                /***将不满足条件的情况去除掉*****/
                 if(((entry.getKey() =='a' && 'x' == entry.getValue()) || ((entry.getKey() =='c' && 'x' == entry.getValue()) || (entry.getKey() =='c' && 'z' == entry.getValue())))){
                     flag = false;
                     break;
                }
             }
             if(flag){
                 System.out.println("对决名单为：");
                 for (Map.Entry<Character, Character> entry : maptmp.entrySet()) {
                     System.out.println("选手："+entry.getKey() + " ----------VS------------ " + "选手："+ entry.getValue());
                 }
             }
        }

    }

    /**
     * 将全部分组情况展示出来
     * @param a
     * @param b
     * @param map
     * @param list
     */
    public static void group(List<Character> a,List<Character> b,Map<Character, Character> map,List<Map> list){
        for (int i = 0; i < a.size(); i++) {
            if (i == 1) {
                break;
            }
            for (int j = 0; j < a.size(); j++) {
                map.put(a.get(i), b.get(j));
                //System.out.println(a.get(i) + "----" + b.get(j));
                if(a.size() == 1){
                    Map<Character, Character> mapTrue = new HashMap<>();
                    mapCopy(map,mapTrue);
                    list.add(mapTrue);
                    //System.out.println(mapTrue);
                }
                List<Character> tmp1 = new ArrayList<>();
                List<Character> tmp2 = new ArrayList<>();
                listCopy(a,tmp1);
                listCopy(b,tmp2);

                tmp1.remove(a.get(i));
                tmp2.remove(b.get(j));
                group(tmp1,tmp2,map,list);
            }
        }
    }

    /**
     * 将paramsMap内容复制到resultMap中
     * @param paramsMap
     * @param resultMap
     */
    public static void mapCopy(Map paramsMap, Map resultMap) {
        if (resultMap == null) resultMap = new HashMap();
        if (paramsMap == null) return;

        Iterator it = paramsMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            resultMap.put(key, paramsMap.get(key) != null ? paramsMap.get(key) : "");
        }
    }

    /**
     * 将paramsList内容复制到resultList中
     * @param paramsList
     * @param resultList
     */
    public static void listCopy(List paramsList,List resultList){
        for (int k = 0; k < paramsList.size(); k++) {
            resultList.add(paramsList.get(k));
        }
    }

}
