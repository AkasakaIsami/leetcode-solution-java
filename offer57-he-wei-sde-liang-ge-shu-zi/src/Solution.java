/**
 * @author Akasaka Isami
 * @description
 * @date 2022-06-29 10:48:56
 * @URL https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 */
public class Solution {
    // 双指针 最大的加最小的都比target大，所以最大的数舍弃；最小的加最大的都比target小，所以最小的舍弃
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (nums[l] + nums[r] != target) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{nums[l],nums[r]};
    }
}
