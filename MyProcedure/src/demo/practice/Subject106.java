package demo.practice;

/**
 * ����һ�������� n������һ������ 1 �� n2 ����Ԫ�أ���Ԫ�ذ�˳ʱ��˳���������е������ξ���
 */
public class Subject106 {

    public static void main(String[] args) {
        int[][] arr = new Subject106().generateMatrix(3);
    }

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int ward = 0;  //���з��� 0 ���ң�1 �ϵ��£�2 �ҵ���3 �µ��ϡ�
        for (int i = 1; i <= n*n; i++) {
            arr[0][i] = i;
        }

        return arr;
    }
}
