package demo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * ������18��
 * ��Ŀ������ƹ����ӽ��б������������ˡ��׶�Ϊa,b,c���ˣ��Ҷ�Ϊx,y,z���ˡ��ѳ�ǩ���������������������Ա����������������
 * a˵������x�ȣ�c˵������x,z�ȣ��������ҳ��������ֵ�������
 *
 * ������Ŀ������չʵ���ˣ��ܹ����Գ��ֶ��������
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
                /***�����������������ȥ����*****/
                 if(((entry.getKey() =='a' && 'x' == entry.getValue()) || ((entry.getKey() =='c' && 'x' == entry.getValue()) || (entry.getKey() =='c' && 'z' == entry.getValue())))){
                     flag = false;
                     break;
                }
             }
             if(flag){
                 System.out.println("�Ծ�����Ϊ��");
                 for (Map.Entry<Character, Character> entry : maptmp.entrySet()) {
                     System.out.println("ѡ�֣�"+entry.getKey() + " ----------VS------------ " + "ѡ�֣�"+ entry.getValue());
                 }
             }
        }

    }

    /**
     * ��ȫ���������չʾ����
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
     * ��paramsMap���ݸ��Ƶ�resultMap��
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
     * ��paramsList���ݸ��Ƶ�resultList��
     * @param paramsList
     * @param resultList
     */
    public static void listCopy(List paramsList,List resultList){
        for (int k = 0; k < paramsList.size(); k++) {
            resultList.add(paramsList.get(k));
        }
    }

}
