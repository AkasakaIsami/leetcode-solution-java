/**
 * 位运算。
 * <p>You can check the problem detail on <a href="https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/">Leetcode</a>.</p>
 * <p><a href="https://leetcode.cn/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/jin-zhi-tao-wa-ru-he-yong-wei-yun-suan-wan-cheng-j/">这个题解</a>写的真的很好！</p>
 *
 * @author Akasaka Isami
 * @since 2022-07-15 13:06:34
 */
public class Solution {
    public int add(int a, int b) {
        if (b == 0)
            return a;

        int sum = a ^ b;
        int carry = a & b << 1;

        return add(sum, carry);
    }
}
