package demo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class var {
    /**
     * [0-9]{6,10} ����0-9����ƥ��6-10�Σ�
     * @ ƥ��һ��@����
     * [A-Za-z0-9]{2,4} ƥ����ĸ������ƥ��2��4�Ρ�
     * (.com.cn)? ƥ��0�λ���1�θ��ַ���
     */
    private static String REGEX = "[0-9]{6,10}@[A-Za-z0-9]{2,4}(.com.cn)?(.com)?";
    private static String INPUT = "774834@QQ.com;;hjajshflsdfl;er29953345563344533788988@qq.com.cnhasjkercssdffssd@163.com.cn";
    private static String REPLACE = "-";
    public static void main(String[] agrs){
        Pattern p = Pattern.compile(REGEX);
        // ��ȡ matcher ����
        Matcher m = p.matcher(INPUT);
        while(m.find()){
            System.out.println(INPUT.substring(m.start(),m.end()));
        }
    }
}
