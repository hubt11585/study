package demo.practice;

/**
 * ������99��
 * n �ʺ������о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 * ����һ������ n�����ذڷŷ���������
 * ÿһ�ֽⷨ����һ����ȷ��?n �ʺ���������ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��
 * ʾ��:
 * ����: 4
 * ���: 2
 */
public class Subject99 {

    public static void main(String[] args) {
        Integer i = new Subject99().totalNQueens(4);
        System.out.println(i);
    }

    int count = 0;

    public int totalNQueens(int n) {
        dfs(0, 0, 0, 0, n);  // ��0��ʼ���������ˣ�dfs���Զ��������п��ܷ���
        return count;
    }

    private void dfs(int row, int qCol, int larger, int smaller, int n) {
        if (row >= n) count++;

        int bits = (~(qCol | larger | smaller)) & ((1 << n) - 1);
        while (bits != 0) {
            int tryBit = bits & -bits;  // ��ȡ���λ,���Ա�����ʧ�������
            dfs(row + 1, qCol | tryBit,(larger | tryBit) << 1,(smaller | tryBit) >> 1, n);
            bits &= bits - 1; // ɾ�����λ,������һ����ѡcur
        }
    }
}
