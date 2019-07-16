package demo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 【程序59】
 * 阿拉伯数字转罗马数字，罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 */
public class Subject59 {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    /**
     * 阿拉伯数字转罗马数字
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        List<String> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        int i = num;
        int num0 = 1;
        while(i > 0){
            int tmp = i%10;
            if(num0 == 1){
                if(tmp == 4){
                    list.add("IV");
                }else if(tmp == 9) {
                    list.add("IX");
                }else{
                    list.add(AssembleNumber(tmp,"I","V"));
                }
            }else if(num0 == 10){
                if(tmp == 4){
                    list.add("XL");
                }else if(tmp == 9) {
                    list.add("XC");
                }else{
                    list.add(AssembleNumber(tmp,"X","L"));
                }
            }else if(num0 == 100){
                if(tmp == 4){
                    list.add("CD");
                }else if(tmp == 9) {
                    list.add("CM");
                }else{
                    list.add(AssembleNumber(tmp,"C","D"));
                }
            }else{
                list.add(AssembleNumber(tmp,"M",""));
            }
            num0 = num0*10;
            i = i/10;
        }
        for(int index=list.size()-1 ;index >= 0;index--){
            result.append(list.get(index));
        }
        return result.toString();
    }

    /**
     * 转化
     * @param tmp
     * @param str0
     * @param str1
     * @return
     */
    public static String AssembleNumber(int tmp,String str0,String str1){
        String result = "";
        if(tmp < 4){
            for (int i=1;i <= tmp;i++){
                result = result+str0;
            }
        }else{
            result = result+str1;
            for (int i=1;i <= tmp-5;i++){
                result = result+str0;
            }
        }
        return result;
    }
}
