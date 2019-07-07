package demo.practice;

/**
 * 【程序55】
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 */
public class Subject55 {
    public static void main(String[] args) {
        String str = " -2147483649ww";
        int i= myAtoi(str);
        System.out.println(i);
    }
    public static int myAtoi(String str) {
        int radix = 10;
        if (str == null) {
            return 0;
        }else{
            str = str.trim();
        }

        int result = 0;
        boolean negative = false;
        int i = 0, len = str.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = str.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    return 0;

                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(str.charAt(i++),radix);
                if (digit < 0) {
                    break;
                }
                if (result < multmin) {
                    result = limit;
                    break;
                }
                result *= radix;
                if (result < limit + digit) {
                    result = limit;
                    break;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        return negative ? result : -result;
    }
}
