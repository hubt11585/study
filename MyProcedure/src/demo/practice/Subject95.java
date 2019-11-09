package demo.practice;

/**
 * ����һ�� n��n �Ķ�ά�����ʾһ��ͼ��
 * ��ͼ��˳ʱ����ת 90 �ȡ�
 * ˵����
 * �������ԭ����תͼ������ζ������Ҫֱ���޸�����Ķ�ά�����벻Ҫʹ����һ����������תͼ��
 */
public class Subject95 {
    public static void main(String[] args) {
        int[][] arrInt = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        new Subject95().rotate(arrInt);
        System.out.println(arrInt);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
