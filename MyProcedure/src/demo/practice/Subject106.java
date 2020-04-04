package demo.practice;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 */
public class Subject106 {

    public static void main(String[] args) {
        int[][] arr = new Subject106().generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int ward = 0;  //运行方向， 0 左到右；1 上到下；2 右到左；3 下到上。
        for (int i = 1; i <= n*n; i++) {
            arr[0][i] = i;
        }

        return arr;
    }
}
