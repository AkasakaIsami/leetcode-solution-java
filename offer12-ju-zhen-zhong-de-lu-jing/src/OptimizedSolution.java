/**
 * Created on 2022/4/5 5:44 AM.
 *
 * @author akasakaisami
 */
public class OptimizedSolution {
    char[][] board;
    int len1, len2;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        char[] words = word.toCharArray();
        len1 = board.length;
        len2 = board[0].length;
        for (int m = 0; m < len1; m++)
            for (int n = 0; n < len2; n++) {
                if (dfs(m, n, 0, words))
                    return true;
            }

        return false;
    }

    /**
     * @param i     当前横坐标
     * @param j     当前纵坐标
     * @param index 期望值下标
     */
    boolean dfs(int i, int j, int index, char[] word) {
        // 终止条件 达到了word最后一个字母
        if (index == word.length) {
            return true;
        }

        // 终止条件 越界
        if (i < 0 || j < 0 || i >= len1 || j >= len2 || board[i][j] != word[index])
            return false;

        // 终止条件 当前元素被访问过
        board[i][j] = '\0';
        index++;

        if (dfs(i + 1, j, index, word) || dfs(i - 1, j, index, word) ||
                dfs(i, j + 1, index, word) || dfs(i, j - 1, index, word)) {
            return true;
        }
        board[i][j] = word[index - 1];

        return false;
    }
}
