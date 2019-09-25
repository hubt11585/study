package demo.practice;

/**
 * �ж�һ��9x9 �������Ƿ���Ч��ֻ��Ҫ�������¹�����֤�Ѿ�����������Ƿ���Ч���ɡ�
 * ����1-9��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����1-9��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����1-9��ÿһ���Դ�ʵ�߷ָ���3x3����ֻ�ܳ���һ�Ρ�
 */
public class Subject83 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};
        System.out.println( new Subject83().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        int[] rowCnt = new int[9];
        int[] colCnt = new int[9];
        int[] boxCnt = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ('.' == board[i][j]) {
                    continue;
                }
                //�����int��
                int num = board[i][j] - 48;
                // ������
                if ((rowCnt[i] >> num) % 2 == 1) {
                    return false;
                } else {
                    rowCnt[i] += 1 << num;
                }
                // ������
                if ((colCnt[j] >> num) % 2 == 1) {
                    return false;
                } else {
                    colCnt[j] += 1 << num;
                }
                // �����
                int boxNum = i / 3 * 3 + j / 3;
                if ((boxCnt[boxNum] >> num) % 2 == 1) {
                    return false;
                } else {
                    boxCnt[boxNum] = boxCnt[boxNum] + (1 << num);
                }
            }
        }
        return true;
    }
}
