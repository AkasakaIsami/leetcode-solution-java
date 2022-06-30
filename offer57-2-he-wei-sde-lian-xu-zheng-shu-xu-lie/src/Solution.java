import java.util.ArrayList;

/**
 * @author Akasaka Isami
 * @description
 * @date 2022-06-30 10:51:08
 * @URL https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 */

// 滑动窗口
public class Solution {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> result = new ArrayList<>();

        int l = 0, r = 1;
        int sum;
        while (l < r && r < target) {
            // 等差数列求和
            sum = (r - l + 1) * (l + 1 + r + 1) / 2;

            // 加入数组
            if (sum == target) {
                int[] tempResult = new int[r - l + 1];
                for (int i = 0; i < r - l + 1; i++) {
                    tempResult[i] = l + 1 + i;
                }
                result.add(tempResult);
                r++;
            } else if (sum < target) {
                // 右指针右移
                r++;
            } else {
                l++;
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}
