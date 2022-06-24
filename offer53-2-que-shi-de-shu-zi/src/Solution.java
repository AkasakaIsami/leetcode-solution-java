/**
 * Created on 2022/6/21 6:48 PM.
 *
 * @author akasakaisami
 * @URL https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/
 */
public class Solution {
    public int missingNumber(int[] nums) {
        // 二分 如果有一个中间数字和下标不一样 数字就在左遍

        int len = nums.length;
        if (len == 0)
            return 0;

        int lp = 0, rp = len - 1, mp = -1;

        while (!(lp > rp)) {
            mp = (lp + rp) / 2;

            // 终止条件
            if (nums[mp] == mp + 1 && (mp == 0 || nums[mp - 1] == mp - 1)) {
                break;
            } else if (nums[mp] == mp) {
                // 数字在右边，左指针右移
                lp = mp + 1;
            } else {
                rp = mp - 1;
            }
        }

        if (mp == len - 1 && nums[mp] == mp)
            return len;

        return mp;
    }

}
