/**
 * Created on 2022/6/12 9:34 PM.
 *
 * @author akasakaisami
 * @URL https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class Solution {
    // dp
    public int maxValue(int[][] grid) {
        // 缓存当前格子可以拿到的最大礼物
        int height = grid.length;
        if (height == 0)
            return 0;

        int width = grid[0].length;
        if (width == 0)
            return 0;

        int[][] dp = new int[height][width];
        dp[0][0] = grid[0][0];

        int i,j;
        for (i = 1; i < height; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (i = 1; i < width; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 状态转移方程：dp[i][j]=max(dp[i-1][j],dp[i][j-1]) + grid[i][j]
        // 主要和上面的格子还有左边的格子比
        // 状态转递就是从左到右一列一列从上往下传
        for (j = 1; j < width; j++) {
            for (i = 1; i < height; i++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[height - 1][width - 1];
    }

}
