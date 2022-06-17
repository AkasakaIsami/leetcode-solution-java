/**
 * Created on 2022/6/15 10:00 PM.
 *
 * @author akasakaisami
 * @URL https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class Solution {
    public String minNumber(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return "";

        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        int lp = 0, rp = len - 1, pivot = 0;
        quickSort(strs, lp, rp, pivot);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            result.append(strs[i]);
        }
        return result.toString();
    }

    // 快排 看的这：https://www.bilibili.com/video/BV117411x72U?p=2&vd_source=ea6eed2cdd99d79d1b8b871b39d59dc5
    // 讲解的不错！小伙子
    private void quickSort(String[] strs, int lp, int rp, int pivot) {
        // 记录边界，用于递归
        int left = lp, right = rp;
        // 递归终止条件，两个指针重合
        if (lp >= rp)
            return;

        String temp = strs[pivot];

        while (lp < rp) {
            while (lp < rp && isBiggerThan(strs[rp], temp)) {
                rp--;
            }
            while (lp < rp && !isBiggerThan(strs[lp], temp)) {
                lp++;
            }


            if (lp < rp) {
                String t = strs[lp];
                strs[lp] = strs[rp];
                strs[rp] = t;
            }
        }
        strs[pivot] = strs[lp];
        strs[lp] = temp;

        quickSort(strs, left, lp - 1, left);
        quickSort(strs, lp + 1, right, lp + 1);
    }

    private boolean isBiggerThan(String a, String b) {
        return (a + b).compareTo(b + a) > 0;
    }

}


