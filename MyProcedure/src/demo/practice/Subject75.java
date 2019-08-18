package demo.practice;

/**
 * 实现strStr()函数。
 * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 */
public class Subject75 {
    public static void main(String[] args) {
        String haystack = "ssss";
        String needle = "a";
        System.out.println(new Subject75().strStr(haystack,needle));
    }

    /**
     * 实现strStr()函数
     */
    public int strStr(String haystack, String needle) {
        if("".equals(needle) || needle == null){
            return 0;
        }else{
            if("".equals(haystack) || haystack == null ){
                return -1;
            }
        }
        char[] arr0= haystack.toCharArray();
        char[] arr1= needle.toCharArray();
        return strStr0(arr0,arr1,0,arr0.length,-1);
    }

    /**
     * 递归处理
     * @param arr0
     * @param arr1
     * @param side
     * @param lengths0
     * @param result
     * @return
     */
    public int strStr0(char[] arr0, char[] arr1,int side,int lengths0,int result) {
        if(result == 0){
            return side-1;
        }
        boolean flag = false;
        for (int i = side; i < lengths0; i++) {
            if(arr0[i] == arr1[0]){
                side = i;
                flag = true;
                break;
            }
        }
        int tmp = lengths0 - side;
        int lengths1 = arr1.length;
        if(tmp < lengths1 || !flag){
            return -1;
        }else{
            int identification = 0;
            for (int i = 1, j = side+1; i < lengths1; i++,j++) {
                if(arr0[j] != arr1[i]){
                    identification = -1;
                    break;
                }
            }
            side = side+1;
            return strStr0(arr0,arr1,side, lengths0,identification);
        }
    }
}
