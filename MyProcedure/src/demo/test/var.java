package demo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class var {
    /**
     * [0-9]{6,10} ：（0-9数据匹配6-10次）
     * @ 匹配一个@符号
     * [A-Za-z0-9]{2,4} 匹配字母，数字匹配2到4次。
     * (.com.cn)? 匹配0次或者1次该字符串
     */
    private static String REGEX = "[0-9]{6,10}@[A-Za-z0-9]{2,4}(.com.cn)?(.com)?";
    private static String INPUT = "774834@QQ.com;;hjajshflsdfl;er29953345563344533788988@qq.com.cnhasjkercssdffssd@163.com.cn";
    private static String REPLACE = "-";
    public static void main(String[] agrs){
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        while(m.find()){
            System.out.println(INPUT.substring(m.start(),m.end()));
        }
    }
}
