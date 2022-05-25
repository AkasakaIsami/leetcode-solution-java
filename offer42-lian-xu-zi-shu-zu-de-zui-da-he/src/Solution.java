/**
 * Created on 2022/5/25 4:14 PM.
 *
 * @author akasakaisami
 * @URL https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class Solution {
    // 做法是DP 确定状态转移方程和要缓存的内容
    // DP 以当前数字为结尾的 所有连续数组的最大和
    // 以某个数作为结尾，意思就是这个数一定会加上去，那么要看的就是这个数前面的部分要不要加上去。大于零就加，小于零就舍弃。
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;

        int[] dp = new int[len];

        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < len; i++) {
            // 状态转移方程，大于零就加，小于零就舍弃。
            if (dp[i - 1] < 0)
                dp[i] = nums[i];
            else
                dp[i] = dp[i - 1] + nums[i];

            if (result < dp[i])
                result = dp[i];
        }

        return result;
    }
}
