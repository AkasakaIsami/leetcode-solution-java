/**
 * <p>You can check the problem detail on <a href="https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/">Leetcode</a>.</p>
 *
 * @author Akasaka Isami
 * @since 2022-07-15 16:55:44
 */
public class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0)
            return new int[0];

        int[] result = new int[len];
        result[0] = 1;

        int i;
        for (i = 1; i < len; i++) {
            result[i] = result[i - 1] * a[i - 1];
        }

        int temp = 1;
        for (i = len - 2; i >= 0; i--) {
            temp *= a[i + 1];
            result[i] = result[i] * temp;
        }

        return result;
    }
}
