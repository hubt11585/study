package demo.untils;

public class StringUntil {

    /**
     * ÅÐ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ
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
     * ÅÐ¶Ï×Ö·û´®ÊÇ·ñ²»Îª¿Õ
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }
}
