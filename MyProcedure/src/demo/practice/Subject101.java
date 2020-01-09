package demo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class Subject101 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12}};
        System.out.println(new Subject101().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> integerList = new ArrayList<Integer>();
        int col = matrix.length - 1;   //竖(步数)
        if(col <= -1){
            return integerList;
        }
        // 计算循环次数
        int row = matrix[0].length;    //横(步数)
        int ward = 0;  //运行方向， 0 左到右；1 上到下；2 右到左；3 下到上。

        int turnPointRow = 0;  //转折点
        int turnPointCol = 0;  //转折点
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
