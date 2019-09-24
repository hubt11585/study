package demo.practice;

/**
 * 【程序38】
 * 题目：字符串排序。
 */
public class Subject38 {
    public static void main(String[] args) {
        String[] arrStr = new String[]{"asd","bbb","dddd","add","eddd","ccdd","caaa","adds","cvf","dass"};
        System.out.print("初始数组：");
        printStrinArray(arrStr);
        stringOrder(arrStr);
    }

    /**
     * 字符串数组排序
     * @param arrStr
     */
    private static void stringOrder(String[] arrStr) {
        for (int i = 0; i <arrStr.length ; i++) {
            for (int j = i+1; j < arrStr.length; j++) {
                String tmp = "";
                if(arrStr[i].compareTo(arrStr[j]) > 0){
                    tmp = arrStr[i];
                    arrStr[i] =  arrStr[j];
                    arrStr[j] = tmp;
                }
            }
        }
        System.out.print("排序后数组：");
        printStrinArray(arrStr);
    }

    /**
     * 字符串数组打印
     * @param arrStr
     */
    private static void printStrinArray(String[] arrStr) {
        for (int i = 0; i < arrStr.length; i++) {
            System.out.print(arrStr[i]+" ");
        }
        System.out.println();
    }
}
