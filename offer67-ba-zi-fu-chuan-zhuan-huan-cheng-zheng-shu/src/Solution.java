/**
 * <p>You can check the problem detail on <a href="https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/">Leetcode</a>.</p>
 *
 * @author Akasaka Isami
 * @since 2022-07-15 19:04:51
 */
public class Solution {
    public int strToInt(String str) {
        int len = str.length();
        if (len == 0)
            return 0;

        char[] cs = str.toCharArray();

        // 寻找第一个非空字符，且需为数字或正、负号
        int index = 0;
        while (index < len && cs[index] == ' ') {
            index++;
        }

        if (index == len) {
            // 全是空字符
            return 0;
        }

        int result = 0, max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;

        if (cs[index] >= '0' && cs[index] <= '9') {
            // 第一个非空字符是数字
            result += (cs[index] - 48);
            index++;
            while (index < len && cs[index] >= '0' && cs[index] <= '9') {
                if (result > max / 10 || (result == max / 10 && (cs[index] - 48) >= max % 10))
                    return max;

                result *= 10;
                result += (cs[index] - 48);
                index++;
            }
        } else if (cs[index] == '+' || cs[index] == '-') {
            // 第一个非空字符是正负号
            if (cs[index] == '+') {
                // 是正数
                index++;
                while (index < len && cs[index] >= '0' && cs[index] <= '9') {
                    if (result > max / 10 || (result == max / 10 && (cs[index] - 48) >= max % 10))
                        return max;
                    result *= 10;
                    result += (cs[index] - 48);
                    index++;
                }
            } else {
                // 是负数
                index++;
                while (index < len && cs[index] >= '0' && cs[index] <= '9') {
                    if (result < min / 10 || (result == min / 10 && -(cs[index] - 48) <= min % 10))
                        return min;
                    result *= 10;
                    result -= (cs[index] - 48);
                    index++;
                }
            }

        } else return 0;
        return result;
    }

    public static void main(String[] args) {
        new Solution().strToInt("-2147483649");
    }
}
