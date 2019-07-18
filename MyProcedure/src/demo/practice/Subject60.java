package demo.practice;

/**
 * 【程序60】
 * 罗马数字转阿拉伯数字，罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 */
public class Subject60 {
    public static void main(String[] args) {
        System.out.println(romanToInt("V"));
    }

    public static int romanToInt(String s) {
        // I X C M 分别代表1，10，100，1000
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == 'I' || arr[i] == 'X' || arr[i] == 'C' || arr[i] == 'M' ){

            }
        }
    }
}
