package demo.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ������47��
 * ��Ŀ�������ַ������Ӵ����ֵĴ���
 */
public class Subject47 {
    public static void main(String[] args) {
        String str1 = "adsdfgfddghrcadncmbvxcxadakssadkfowp";
        String str2 = "ad";
        strLookCount(str1,str2);
    }

    /**
     * �Ӵ����ִ���
     * @param str1
     * @param str2
     */
    private static void strLookCount(String str1, String str2) {
        Pattern pattern = Pattern.compile(str2);
        Matcher m = pattern.matcher(str1);
        int count=0;
        while(m.find()){
            count++;
        }
        System.out.println("�Ӵ����ִ����� "+count);
    }
}
