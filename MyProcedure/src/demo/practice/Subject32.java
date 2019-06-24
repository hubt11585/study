package demo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 【程序32】
 * 题目：打印出杨辉三角形（要求打印出10行如下图）
 */
public class Subject32 {

    private static int num_1 = 24;
    private static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("杨辉三角形打印如下：");
        yangHuiTriangle(num_1);
        int maxLength = (list.get(list.size()-1)[num_1/2]+"").length();
        boolean flag = isParity(maxLength);
        for (int i = 0 ; i < list.size(); i++) {
            int[] arr = list.get(i);
            printSpace(arr,maxLength);
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]);
                int tmp = (arr[j]+"").length();
                if(flag){
                    for (int k = 0; k < maxLength+2 - tmp; k++) {
                        System.out.print(" ");
                    }
                }else{
                    for (int k = 0; k < maxLength+1 - tmp; k++) {
                        System.out.print(" ");
                    }
                }

            }
            System.out.println();
        }
    }

    /**
     * 判断maxLength是奇数还是偶数
     * @param maxLength
     * @return
     */
    private static boolean isParity(int maxLength) {
        if(maxLength%2 == 1){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 获取杨辉三角数据
     * @param num
     * @return
     */
    private static int[] yangHuiTriangle(int num) {
        if(num == 1){
            int[] arr = new int[]{1};
            list.add(arr);
            return arr;
        }else{
            int[] arrPro = yangHuiTriangle(num-1);
            int[] arrAft = new int[num];
            for (int i = 0; i < arrAft.length ; i++) {
                if(i == 0){
                    arrAft[i] = 0+arrPro[i];
                }else if( i== arrAft.length-1){
                    arrAft[i] = arrPro[i-1]+0;
                }else{
                    arrAft[i] = arrPro[i-1] + arrPro[i];
                }
            }
            list.add(arrAft);
            return arrAft;
        }
    }

    /**
     * 空格打印
     * @param arr
     */
    private static void printSpace(int[] arr,int maxLength) {
        for (int i = 0; i < num_1 - arr.length ; i++) {
            double loopNum = Math.ceil((maxLength+1)/2.0);
            for (int j = 0; j < loopNum; j++) {
                System.out.print(" ");
            }
        }
    }
}
