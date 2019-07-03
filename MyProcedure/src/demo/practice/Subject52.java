package demo.practice;

/**
 * 【程序52】
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class Subject52 {
    public static void main(String[] args) {
        String str = "sdffttrrgfddfh";
        String result= longestPalindrome(str);
        System.out.println(result);
        result = longestPalindrome1(str);
        System.out.println(result);
    }

    /**
     * Manacher算法
     * @param str
     * @return
     */
    private static String longestPalindrome1(String str) {
        char[] cStr = str.toCharArray();
        //插入特殊符号
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("#");
        for (int i = 0; i < cStr.length; i++) {
            sBuffer.append(cStr[i]);
            sBuffer.append("#");
        }
        int id =0;   //回文的中心。
        int max = 0; //回文最大长度。
        //辅助数组
        int[] p= new int[sBuffer.length()];
        for (int i = 1; i < sBuffer.length(); i++) {

            if (i<max) {
                p[i] = Math.min(p[2*id-i], max-i);
            }else {
                p[i]= 1;
            }
            //判断中心两边是否回文，是则++;
            while (i-p[i]>=0&&i+p[i]<sBuffer.length()&&sBuffer.charAt(i-p[i])==sBuffer.charAt(i+p[i])) {
                p[i]++;
            }
            if (i+p[i]>max) {
                max = i+p[i];
                id = i;
            }
        }
        int maxl = 0 ;
        int maxid =0 ;
        for(int i =0 ;i<p.length;i++){
            if(maxl<p[i]){
                maxl=p[i];
                maxid = i;
            }
        }
        //半径包括id本身。id到第一个元素，id-r+1
        int r = maxl-1;
        int start = maxid-r+1;
        int end = maxid+maxl-1;
        StringBuffer out = new StringBuffer();
        for (int i = start; i < end; i++) {
            if (sBuffer.charAt(i)!='#') {
                out.append(sBuffer.charAt(i));
            }
        }
        return out.toString();
    }


    /**
     * 获取最长回文数
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String result = "";
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < arr.length; i++){
            for (int j = 0; j <= i; j++) {
                //判断是否回文。
                result =  palindromeStr(s,arr,i,j);
                if(!"".equals( result) ){
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * 判断字符串是否是回文字符串
     * @param s
     * @param arr
     * @param i
     * @param j
     * @return
     */
    private static String palindromeStr(String s,char[] arr, int i, int j) {
        String result = "";
        int start = j;
        int end = arr.length-(i-j)-1;
        while(start <= end){
            if(arr[start] == arr[end]){
                if(start+1 >= end){
                    result = s.substring(j,arr.length-(i-j));
                    return result;
                }
                start++;
                end--;
            }else{
                break;
            }
        }
        return result;
    }
}
