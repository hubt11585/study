package demo.practice;

/**
 * ��дһ������ͨ�������Ŀո�������������⡣
 * һ�������Ľⷨ����ѭ���¹���
 * ����1-9��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����1-9��ÿһ��ֻ�ܳ���һ�Ρ�
 * ����1-9��ÿһ���Դ�ʵ�߷ָ���3x3����ֻ�ܳ���һ�Ρ�
 * �հ׸���'.'��ʾ��
 */
public class Subject84 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}};
        new Subject84().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    // box size
    int n = 3;
    // row size
    int N = n * n;

    int [][] rows = new int[N][N + 1];
    int [][] columns = new int[N][N + 1];
    int [][] boxes = new int[N][N + 1];

    char[][] board;

    boolean sudokuSolved = false;

    public boolean couldPlace(int d, int row, int col) {
    /*
    ����Ƿ�����ڣ��У��У���Ԫ���з�������d
    */
        int idx = (row / n ) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void placeNumber(int d, int row, int col) {
    /*
    �ڣ��У��У���Ԫ���з�������d
    */
        int idx = (row / n ) * n + col / n;

        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char)(d + '0');
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void removeNumber(int d, int row, int col) {
    /*
    ɾ��һ���޷��ҵ��������������
    */
        int idx = (row / n ) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';
    }

    public void placeNextNumbers(int row, int col) {
    /*
    �ݹ���û��ݺ���
    ������������
    ֱ�������ҵ�����취
    */
        // ������������һ���η���
        // ����ζ�������а취
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        }
        // �����û��
        else {
            // ��������������
            // ����һ��
            if (col == N - 1) backtrack(row + 1, 0);
                // go to the next column
            else backtrack(row, col + 1);
        }
    }

    public void backtrack(int row, int col) {
    /*
    ����
    */
        // �����Ԫ���ǿյ�
        if (board[row][col] == '.') {
            // �Դ�1��9���������ֽ��е���
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    // ��������������ˣ��Ͳ��ػ�ͷ�ˡ�
                    // ��Ϊ���������������ϣ����
                    if (!sudokuSolved) removeNumber(d, row, col);
                }
            }
        }
        else placeNextNumbers(row, col);
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        // ��ʼ���С��кͿ�
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);
    }
}
