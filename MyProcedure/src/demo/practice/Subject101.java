package demo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������ m x n ��Ԫ�صľ���m ��, n �У����밴��˳ʱ������˳�򣬷��ؾ����е�����Ԫ�ء�
 */
public class Subject101 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12}};
        System.out.println(new Subject101().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> integerList = new ArrayList<Integer>();
        int col = matrix.length - 1;   //��(����)
        if(col <= -1){
            return integerList;
        }
        // ����ѭ������
        int row = matrix[0].length;    //��(����)
        int ward = 0;  //���з��� 0 ���ң�1 �ϵ��£�2 �ҵ���3 �µ��ϡ�

        int turnPointRow = 0;  //ת�۵�
        int turnPointCol = 0;  //ת�۵�
        while(true){
            if(ward == 0){
                for (int j = 0; j < row; j++) {
                    integerList.add(matrix[turnPointRow][turnPointCol++]);
                }
                turnPointCol--;
                turnPointRow++;
                if(row-- == 0){
                    break;
                }
                ward++;
            } else if (ward == 1){
                for (int j = 0; j < col; j++) {
                    integerList.add(matrix[turnPointRow++][turnPointCol]);
                }
                turnPointRow--;
                turnPointCol--;
                if(col-- == 0){
                    break;
                }
                ward++;
            } else if (ward == 2){
                for (int j = 0; j < row; j++) {
                    integerList.add(matrix[turnPointRow][turnPointCol--]);
                }
                turnPointCol++;
                if(row-- == 0){
                    break;
                }
                turnPointRow--;
                ward++;
            } else if (ward == 3){
                for (int j = 0; j < col; j++) {
                    integerList.add(matrix[turnPointRow--][turnPointCol]);
                }
                turnPointRow++;
                turnPointCol++;
                if(col-- == 0){
                    break;
                }
                ward = 0;
            }
        }
        return integerList;
    }
}
