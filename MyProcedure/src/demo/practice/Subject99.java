package demo.practice;

/**
 * 【程序99】
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回摆放方案数量。
 * 每一种解法包含一个明确的?n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 示例:
 * 输入: 4
 * 输出: 2
 */
public class Subject99 {

    public static void main(String[] args) {
        Integer i = new Subject99().totalNQueens(4);
        System.out.println(i);
    }

    int count = 0;

    public int totalNQueens(int n) {
        dfs(0, 0, 0, 0, n);  // 从0开始遍历就行了，dfs会自动遍历所有可能方案
        return count;
    }

    private void dfs(int row, int qCol, int larger, int smaller, int n) {
        if (row >= n) count++;

        int bits = (~(qCol | larger | smaller)) & ((1 << n) - 1);
        while (bits != 0) {
            int tryBit = bits & -bits;  // 获取最低位,尝试遍历，失败则回溯
            dfs(row + 1, qCol | tryBit,(larger | tryBit) << 1,(smaller | tryBit) >> 1, n);
            bits &= bits - 1; // 删除最低位,尝试下一个候选cur
        }
    }
}
