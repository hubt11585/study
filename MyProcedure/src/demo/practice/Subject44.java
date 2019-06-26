package demo.practice;

/**
 * 【程序44】
 * 题目：两个字符串连接程序（该题为C代码题目。）使用C方式实现该程序
 */
public class Subject44 {
    public static void main(String[] args) {
        String str1 = "张三";
        String str2 = "李晓明";
        splicingStr(str1,str2);
    }

    private static void splicingStr(String str1, String str2) {
        /*****java实现***************/
        System.out.println("java实现："+str1 + str2);
        /*****C实现,C言语字符串本身就是需要使用char[] 数组保存的，这里就不再从新写了***************/
        char[] arrStr1 = str1.toCharArray();
        char[] arrStr2 = str2.toCharArray();
        char[] arrStrSum = new char[arrStr1.length + arrStr2.length];
        for (int i = 0; i < arrStrSum.length; i++) {
            if(i < str1.length()){
                arrStrSum[i] = arrStr1[i];
            }else{
                arrStrSum[i] = arrStr2[i-str1.length()];
            }
        }
        System.out.print("C语言方式实现：");
        printArray(arrStrSum);
    }
    /**
     * 打印数组
     * @param arr
     */
    private static void printArray(char[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
