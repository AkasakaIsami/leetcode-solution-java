/**
 * @author Akasaka Isami
 * @description
 * @date 2022-06-27 13:58:25
 * @URL https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 */
public class Solution {
    // 位运算来做的，详细看这个视频吧：https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-by-leetcode/
    public int[] singleNumbers(int[] nums) {
        int temp = 0;
        for (int i : nums) {
            temp ^= i;
        }
        // temp 就是要找的两个数字的异或结果
        // 根据异或结果中某个为 1 的位将数组分为两个
        int m = 1;/** m二进制 0001 **/

        // 找temp里为1的某一位
        while ((temp & m) == 0) {
            m <<= 1;
        }

        int a = 0, b = 0;
        for (int i : nums) {
            if ((m & i) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }

        return new int[]{a, b};
    }
}
