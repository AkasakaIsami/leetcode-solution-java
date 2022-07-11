import java.util.Arrays;

/**
 * 动态规划。
 * <p>You can check the problem detail on <a href="https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/">Leetcode</a>.</p>
 *
 * @author Akasaka Isami
 * @since 2022-07-11 10:42:18
 */
public class Solution {
    /**
     * 动态规划
     * <p>dp[ n ][ sum ]表示 n 个骰子骰出和为 sum 的情况总数</p>
     * <p>状态转移方程：dp[ n ][ sum ] = ( i = 1 )∑( 6 ) dp[ n-1 ][ sum-i ], 其中 n 为筛子数量，sum 为和</p>
     */
    public double[] dicesProbability(int n) {
        // 66 这个数字有说法，因为 1 <= n <= 11，最多 sum 只能是 66
        double[][] dp = new double[n][67];

        // dp初始化
        for (int i = 1; i <= 6; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= 6 * i + 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (j - 1 - k > 0)
                        dp[i][j] += dp[i - 1][j - 1 - k];
                }
            }
        }

        int len = 5 * n + 1;
        double[] result = Arrays.copyOfRange(dp[n - 1], n, n + len);

        double num = Math.pow(6, n);

        for (int i = 0; i < result.length; i++) {
            result[i] /= num;
        }

        return result;
    }

}
