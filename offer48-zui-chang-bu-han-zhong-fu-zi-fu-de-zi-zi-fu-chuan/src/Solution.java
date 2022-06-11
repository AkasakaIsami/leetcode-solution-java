import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created on 2022/6/11 11:58 PM.
 *
 * @author akasakaisami
 * @URL https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class Solution {
    // dp
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0)
            return 0;

        // 存储 当前index下的最长无重复字符字串长度
        int[] dp = new int[len];

        // 状态转移方程：dp[i] = (如果当前字串包含当前字符的话，从重复字符开始的新长度)/（不包含当前字符的话 ++）
        dp[0] = 1;

        // 存储当前的无重复字符子串
        Deque<Character> deque = new LinkedList<>();
        char[] chars = s.toCharArray();
        deque.offerLast(chars[0]);

        int max = dp[0];
        int tempLen = -1;
        for (int i = 1; i < len; i++) {
            // 判断当前字符是否包含在当前子串
            if (deque.contains(chars[i])) {
                tempLen = dp[i - 1];
                // 移除重复字符前的所有字符
                while (deque.getFirst() != chars[i]) {
                    deque.pollFirst();
                    tempLen--;
                }
                deque.pollFirst();
                deque.offerLast(chars[i]);
                dp[i] = tempLen;
            } else {
                deque.offerLast(chars[i]);
                dp[i] = dp[i - 1] + 1;
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
