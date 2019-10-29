package demo.practice;

/**
 * 给定一个字符串(s) 和一个字符模式(p) ，实现一个支持'?'和'*'的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 */
public class Subject91 {
    public static void main(String[] args) {
        String str1 = "abbabaaabababbaababbabbbbbabbbabb";
        String str2 = "**aa*abb***";
        System.out.println(new Subject91().isMatch(str1,str2));
    }

    boolean isMatch(String str, String pattern) {

        int s = 0, p = 0, match = 0, starIdx = -1;
        //遍历整个字符串
        while (s < str.length()){
            // 一对一匹配，两指针同时后移。
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // 碰到 *，假设它匹配空串，并且用 startIdx 记录 * 的位置，记录当前字符串的位置，p 后移
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // 当前字符不匹配，并且也没有 *，回退
            // p 回到 * 的下一个位置
            // match 更新到下一个位置
            // s 回到更新后的 match
            // 这步代表用 * 匹配了一个字符
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //字符不匹配，也没有 *，返回 false
            else return false;
        }

        //将末尾多余的 * 直接匹配空串 例如 text = ab, pattern = a*******
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
