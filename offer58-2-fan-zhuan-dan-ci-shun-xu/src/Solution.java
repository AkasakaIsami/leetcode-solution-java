import java.util.Arrays;

/**
 * @author Akasaka Isami
 * @description
 * @date 2022-07-01 09:40:16
 * @URL https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 */
public class Solution {
    public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        // 双指针互相追逐 从右向左移动
        int fast = len - 1, slow = len - 1;

        char[] result = new char[len];
        int index = 0;

        while (true) {
            // 跳过空格字符 fast找到下一个空格前的第一个非空格字符 e.g. the sky   的 y或e
            while (fast >= 0 && cs[fast] == ' ') {
                fast--;
            }
            slow = fast;

            if (fast < 0) {
                // 到头了
                break;
            } else {
                // 结果字符串里只填入一个空格
                if (index != 0) {
                    result[index] = ' ';
                    index++;
                }

                // 找到以后快指针先左移，找到第一个空格后的位置 e.g. the sky   的 s
                while (fast > 0 && cs[fast - 1] != ' ')
                    fast--;

                // 从快指针打印到慢指针
                for (int i = fast; i < slow + 1; i++) {
                    result[index] = cs[i];
                    index++;
                }
                fast--;
            }
        }
        return String.valueOf(Arrays.copyOfRange(result, 0, index));
    }

}
