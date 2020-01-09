package demo.untils;

import java.util.Objects;

public class StringUntil {

    public static void main(String[] args) {
        String str = "1.23.";
        System.out.println(isInteger(str));
        System.out.println(isDecimal(str));
    }

    /**
     * ?ж????????????
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    /**
     * ?ж????????????
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 判断是否为整数
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        if (str == null || Objects.equals(str,"")) {
            return false;
        } else {
            int sz = str.length();
            int i = 0;
            if (str.charAt(i) == '-' || str.charAt(i) == '+')  i++;
            for(; i < sz; i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 判断是否为小数
     * @param str
     * @return
     */
    public static boolean isDecimal(String str) {
        if (str == null || Objects.equals(str,"")) {
            return false;
        } else {
            int sz = str.length();
            int pointCount = 0;
            int i = 0;
            if (str.charAt(i) == '-' || str.charAt(i) == '+')  i++;
            for(; i < sz; i++) {
                if(str.charAt(i) == '.'){
                    if(pointCount++ == 1){
                        return false;
                    }
                    continue;
                } else if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
