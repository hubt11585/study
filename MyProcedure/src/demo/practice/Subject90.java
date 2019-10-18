package demo.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Subject90 {
    public static void main(String[] args) {
        String num1 = "2222";
        String num2 = "3333";
        System.out.println(2222*3333);
        String nultiply = new Subject90().multiply(num1,num2);
        System.out.println(nultiply);
    }
    public String multiply(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Integer,StringBuilder> map = new HashMap<>();

        char[] arrChar1 = num1.toCharArray();
        char[] arrChar2 = num2.toCharArray();

        int tmp = 0;
        for (int i = arrChar1.length-1 , k=0; i >= 0 ; i--,k++) {
            StringBuilder stringBuilderTmp = new StringBuilder();
            for (int j = 0; j < k ; j++) {
                stringBuilderTmp.append(0);
            }
            if(!map.containsKey(i)) {
                for (int j = arrChar2.length - 1; j >= 0; j--) {
                    int number = (arrChar1[i] - 48) * (arrChar2[j] - 48) % 10 + tmp;
                    stringBuilderTmp.append(number);
                    tmp = (arrChar1[i] - 48) * (arrChar2[j] - 48) / 10;
                }
                if(tmp != 0){
                    stringBuilderTmp.append(tmp);
                }
                map.put(i,stringBuilderTmp);
            }else{
                stringBuilderTmp = map.get(i);
            }
            //加
            stringBuilder = this.add(stringBuilderTmp.toString(),stringBuilder.toString());
        }

        char[] ch= stringBuilder.reverse().toString().toCharArray();
        int side = -1;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] =='0'){
                side = i;
            }else{
                break;
            }
        }
        return new String(ch,side+1,ch.length-1-side);
    }

    /**
     * 求和
     * @param num1
     * @param num2
     * @return
     */
    public StringBuilder add(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();

        StringBuilder stringBuilder = new StringBuilder();

        char[] arrChar1 = num1.toCharArray();
        char[] arrChar2 = num2.toCharArray();

        int tmp = 0;
        for (int i = 0; i < length1 || i < length2 ; i++) {
            if( i < length1 && i < length2 ){
                int number = ((arrChar1[i] - 48) + (arrChar2[i] - 48)) % 10 + tmp;
                stringBuilder.append(number);
                tmp = ((arrChar1[i] - 48) + (arrChar2[i] - 48)) / 10;
            }else if( i < length1 ){
                int number = (arrChar1[i] - 48) + tmp;
                stringBuilder.append(number);
                tmp = 0;
            }else if( i < length2 ){
                int number = (arrChar2[i] - 48) + tmp;
                stringBuilder.append(number);
                tmp = 0;
            }
        }
        if(tmp != 0){
            stringBuilder.append(tmp);
        }
        return stringBuilder;
    }

}
