package demo.practice;

import java.util.Random;

/**
 * 【程序28】
 * 题目：求一个3*3矩阵对角线元素之和
 */
public class Subject28 {

    public static void main(String[] args) {
        Random random = new Random();
        int[][] arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = random.nextInt(10);
            }
        }

        seekDiagonalSum(arr);
    }

    /**
     * 计算矩阵对角线之后
     * @param arr
     */
    private static void seekDiagonalSum(int[][] arr) {
        int slash = 0;
        int backSlash = 0;

        for (int i = 0; i < arr.length; i++) {
            slash = slash + arr[i][i];
        }

        System.out.println("随机生成的3*3的矩阵为：");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                System.out.print(arr[i][j] + " ");
                if(i+j == arr.length-1){
                    backSlash += arr[i][j];
                }
            }
            System.out.println("");
        }
        System.out.println("正向对角线之和："+slash);
        System.out.println("反向对角线之和："+backSlash);
    }
}
