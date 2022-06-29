/**
 * @author Akasaka Isami
 * @description
 * @date 2022-06-28 15:48:56
 * @URL https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 */
public class Soluiton {
    // 考虑数字的二进制形式，对于出现三次的数字，各 二进制位 出现的次数都是 33 的倍数。
    // 因此，统计所有数字的各二进制位中 11 的出现次数，并对 33 求余，结果则为只出现一次的数字
    // 我的评价是：有毒
    public int singleNumber(int[] nums) {
        // int 32位
        int[] counts = new int[32];

        int m = 1,i;
        for (int num : nums) {
            // 每个数字都遍历32位 出现1就计数一次
            for (i = 0; i < 32; i++) {
                if (((num & m) != 0)) {
                    counts[i]++;
                }
                m <<= 1;
            }
            m = 1;
        }

        int result = 0,count;
        for (i = 31; i >= 0; i--) {
            // 对于每个计数器，如果除得尽3，那就代表result的这一位是0
            // 否则就是1
            count = counts[i];
            result <<= 1;
            if (count % 3 != 0)
                result |= 1;
        }
        return result;
    }
}
