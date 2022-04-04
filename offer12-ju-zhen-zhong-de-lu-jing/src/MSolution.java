/**
 * Created on 2022/4/4 4:28 AM.
 *
 * @author akasakaisami
 */
public class MSolution {
    char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        for (int m = 0; m < board.length; m++)
            for (int n = 0; n < board[0].length; n++) {
                if (board[m][n] == word.charAt(0)) {
                    if (dfs(m, n, 0, word, new boolean[board.length][board[0].length]))
                        return true;
                }
            }

        return false;
    }

    /**
     * @param i     当前横坐标
     * @param j     当前纵坐标
     * @param index 期望值下标
     */
    boolean dfs(int i, int j, int index, String word, boolean[][] record) {
        // 终止条件 达到了word最后一个字母
        if (index == word.length()) {
            return true;
        }
        // 终止条件 越界
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;

        // 终止条件 当前元素被访问过
        if (record[i][j])
            return false;

        // 终止条件 不相等
        if (board[i][j] == word.charAt(index)) {
            record[i][j] = true;
            index++;
            if (dfs(i + 1, j, index, word, record) || dfs(i - 1, j, index, word, record) ||
                    dfs(i, j + 1, index, word, record) || dfs(i, j - 1, index, word, record)) {
                return true;
            }
            record[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] s = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new MSolution().exist(s, "ABCESEEEFS"));
    }
}
