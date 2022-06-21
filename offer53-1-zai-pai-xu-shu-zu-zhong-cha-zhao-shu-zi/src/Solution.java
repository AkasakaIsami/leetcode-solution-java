/**
 * Created on 2022/6/21 5:41 PM.
 *
 * @author akasakaisami
 * @URL https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Solution {
    // 有序数组用二分
    public int search(int[] nums, int target) {
        // 二分 左右边界存在任何一个是目标就停止
        int len = nums.length;
        if (len == 0)
            return 0;

        int lp = 0, rp = len - 1, mp = (lp + rp) / 2;

        while (lp < rp) {
            if (target == nums[mp])
                break;
            else if (target > nums[mp]) {
                // 目标比中间大，就在右边,左指针右移
                lp = mp + 1;
            } else rp = mp - 1;
            mp = (lp + rp) / 2;
        }

        int sum = 1;
        if (target != nums[mp]) {
            return 0;
        } else {
            lp = mp - 1;
            rp = mp + 1;
            while (lp >= 0 && nums[lp] == target) {
                sum++;
                lp--;
            }
            while (rp < len && nums[rp] == target) {
                sum++;
                rp++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.search(new int[]{5, 7, 7, 8, 8, 10}, 6);
    }
}
