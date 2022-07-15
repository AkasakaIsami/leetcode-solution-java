/**
 * <p>You can check the problem detail on <a href="https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/">Leetcode</a>.</p>
 *
 * @author Akasaka Isami
 * @since 2022-07-15 12:33:25
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0)
            return 0;

        int maxProfit = 0;

        int min = prices[0];
        int todayProfit;
        for (int i = 1; i < len; i++) {
            if (prices[i] > min) {
                todayProfit = prices[i] - min;
            } else {
                todayProfit = 0;
                min = prices[i];
            }
            maxProfit = Math.max(todayProfit, maxProfit);
        }

        return maxProfit;
    }

}
