/**
 * Created on 2022/4/6 9:16 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    int count = 0;

    public int movingCount(int m, int n, int k) {
        dfs(0, 0, m, n, k, new boolean[m][n]);
        return count;
    }

    /**
     * 深度优先遍历，当前格子发散递归
     *
     * @param x 当前格子横坐标
     * @param y 当前格子纵坐标
     * @param m 棋盘高度
     * @param n 棋盘长度
     * @param k 数位之和最大值
     */
    private void dfs(int x, int y, int m, int n, int k, boolean[][] record) {
        // 终止条件1 越界
        if (x < 0 || y < 0 || x >= m || y >= n)
            return;
        // 终止条件2 已经走过的格子
        if (record[x][y])
            return;
        // 终止条件3 数位之和大于k
        if (sum(x, y) > k)
            return;

        count++;
        record[x][y] = true;
        dfs(x + 1, y, m, n, k, record);
        dfs(x - 1, y, m, n, k, record);
        dfs(x, y + 1, m, n, k, record);
        dfs(x, y - 1, m, n, k, record);
    }

    /**
     * 求输入两数的数位之和
     *
     * @param x 第一个数
     * @param y 第二个数
     * @return 两数数位之和
     */
    private int sum(int x, int y) {
        return x / 10 + x % 10 + y / 10 + y % 10;
    }

    public static void main(String[] args) {
        System.out.println(new MSolution().movingCount(3, 1, 0));
    }
}
