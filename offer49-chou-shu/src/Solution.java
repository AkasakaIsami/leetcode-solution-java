/**
 * Created on 2022/5/30 10:36 PM.
 *
 * @author akasakaisami
 * @URL https://leetcode.cn/problems/chou-shu-lcof/
 */

// 这个网址说的好 https://www.bilibili.com/video/BV1o541177He?spm_id_from=333.337.search-card.all.click
// 似乎只用三指针就可以了，真的需要dp吗？
public class Solution {
    public int nthUglyNumber(int n) {
        // dp+三指针
        // 状态转移方程：dp[i]=min[dp[p2]*2,dp[p3]*3,dp[p5]*5]

        int[] dp = new int[n];
        dp[0] = 1;

        int p2 = 0, p3 = 0, p5 = 0;
        int temp2, temp3, temp5;
        int min = -1;

        for (int i = 1; i < n; i++) {
            // 状态转移，找三个指针哪个乘完2/3/5后是最小的
            temp2 = 2 * dp[p2];
            temp3 = 3 * dp[p3];
            temp5 = 5 * dp[p5];

            // 最小的那个要移动指针
            min = findMin(temp2, temp3, temp5);
            dp[i] = min;
            if (min == temp2) p2++;
            if (min == temp3) p3++;
            if (min == temp5) p5++;
        }

        return dp[n - 1];
    }

    private int findMin(int temp2, int temp3, int temp5) {
        int min = Math.min(temp2, temp3);

        if (min > temp5)
            min = temp5;

        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }
}

