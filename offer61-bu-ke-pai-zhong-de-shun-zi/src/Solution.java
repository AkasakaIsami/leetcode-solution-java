import java.util.Arrays;

/**
 * <p>You can check the problem detail on <a href="https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/">Leetcode</a>.</p>
 *
 * @author Akasaka Isami
 * @since 2022-07-11 16:06:04
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int p = 0;

        while (nums[p] == 0) {
            p++;
            count++;
        }

        int gap;
        while (p < nums.length - 1) {
            if (nums[p] != nums[p + 1]) {
                gap = nums[p + 1] - nums[p] - 1;
                count -= gap;

                if (count < 0)
                    return false;
            } else return false;
            p++;
        }
        return true;
    }
}