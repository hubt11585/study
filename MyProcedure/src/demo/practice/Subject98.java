package demo.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 * ����һ������ n���������в�ͬ��n�ʺ�����Ľ��������
 * ÿһ�ֽⷨ����һ����ȷ��n �ʺ���������ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��
 * ʾ��:
 * ����: 4
 * ���: [
 * [".Q..",  // �ⷨ 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * ["..Q.",  // �ⷨ 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * ����: 4 �ʺ��������������ͬ�Ľⷨ��
 */
public class Subject98 {

    //���ű�ռ�Ǽǣ������ж��Ƿ��ܹ������Ź���
    int rows[]; //
    // "�����ҶԽ���" �Ǽǣ������ж��Ƿ��ܹ������Ź���
    int hills[];
    // "���ҵ���Խ���" �Ǽǣ������ж��Ƿ��ܹ������Ź���
    int dales[];
    int n;
    // output
    List<List<String>> output = new ArrayList();
    // �ʺ��λ��
    int queens[];

    public static void main(String[] args) {
        List<List<String>> listList = new Subject98().solveNQueens(1);
        System.out.println(listList);
    }

    /**
     * �жϸ�λ���Ƿ�ᱻ����
     * @param row
     * @param col
     * @return
     */
    public boolean isNotUnderAttack(int row, int col) {
        int res = rows[col] + hills[row - col +  n - 1] + dales[row + col];
        return (res == 0) ? true : false;
    }

    /**
     * ���ʺ�����λ��
     * @param row
     * @param col
     */
    public void placeQueen(int row, int col) {
        queens[row] = col;   //���ʺ�λ�÷���
        rows[col] = 1;   //���Ź���λ��
        hills[row - col +  n - 1] = 1;  // "�����ҶԽ���" ����λ��
        dales[row + col] = 1;   //"���ҵ���Խ���" ����λ��
    }

    /**
     * ���ݻʺ�λ��
     * @param row
     * @param col
     */
    public void removeQueen(int row, int col) {
        queens[row] = 0;
        rows[col] = 0;
        hills[row - col + n - 1] = 0;
        dales[row + col] = 0;
    }

    /**
     * �����������Ļʺ�λ�÷���output��
     */
    public void addSolution() {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < col; ++j) sb.append(".");
            sb.append("Q");
            for(int j = 0; j < n - col - 1; ++j) sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    public void backtrack(int row) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                // �ʺ������Ƿ����㣬���������
                if (row + 1 == n) addSolution();
                // �����������
                else backtrack(row + 1);
                // ���ݡ�
                removeQueen(row, col);
            }

        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        rows = new int[n];
        hills = new int[2 * n - 1];
        dales = new int[2 * n - 1];
        queens = new int[n];

        backtrack(0);
        return output;
    }
}
