/**
 * @author Akasaka Isami
 * @createDate 2021/7/23 11:18 AM
 */

public class MSolution {
    public static int rob(int[] nums) {
        int len = nums.length;
        int[] results = new int[len];

        for (int i = 0; i < len; i++) {
            int j = len - i - 1;

            if (i == 0) {
                results[j] = nums[j];
                continue;
            } else if (i == 1) {
                results[j] = Math.max(nums[j], nums[j + 1]);
                continue;
            }

            results[j] = Math.max(results[j + 1], results[j + 2] + nums[j]);
        }

        return results[0];
    }
}
