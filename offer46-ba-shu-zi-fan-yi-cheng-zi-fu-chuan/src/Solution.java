/**
 * Created on 2022/6/14 11:20 PM.
 *
 * @author akasakaisami
 * @URL https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class Solution {
    // dp 有条件dp
    public int translateNum(int num) {
        if (num < 10)
            return 1;

        char[] nums = String.valueOf(num).toCharArray();
        int len = nums.length;
        // 缓存：当前字符有多少种搭配
        int[] dp = new int[len];
        dp[0] = 1;
        // 前两位数大于25的话，就只有1种可能
        dp[1] = (nums[0] > '2') || (nums[0] == '2' && nums[1] > '5') ? 1 : 2;

        // 状态转移方程: dp[i] = dp[i-1] + dp [i-2](最后两个字符<=25) 或 dp[i] = dp[i-1](最后两个字符>25,或最后两字符前一个字符是0)
        for (int i = 2; i < len; i++) {
            if ((nums[i - 1] > '2') || (nums[i - 1] == '2' && nums[i] > '5') || nums[i - 1] == '0')
                dp[i] = dp[i - 1];
            else dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[len - 1];
    }
}
