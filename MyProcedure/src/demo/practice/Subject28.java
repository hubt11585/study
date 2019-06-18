package demo.practice;

import java.util.Random;

/**
 * ������28��
 * ��Ŀ����һ��3*3����Խ���Ԫ��֮��
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
     * �������Խ���֮��
     * @param arr
     */
    private static void seekDiagonalSum(int[][] arr) {
        int slash = 0;
        int backSlash = 0;

        for (int i = 0; i < arr.length; i++) {
            slash = slash + arr[i][i];
        }

        System.out.println("������ɵ�3*3�ľ���Ϊ��");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                System.out.print(arr[i][j] + " ");
                if(i+j == arr.length-1){
                    backSlash += arr[i][j];
                }
            }
            System.out.println("");
        }
        System.out.println("����Խ���֮�ͣ�"+slash);
        System.out.println("����Խ���֮�ͣ�"+backSlash);
    }
}
