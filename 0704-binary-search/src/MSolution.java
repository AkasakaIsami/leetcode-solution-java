/**
 * Created on 2022/4/1 12:19 AM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public int search(int[] nums, int target) {
        int len = nums.length;

        if (len == 0)
            return -1;
        if (len == 1)
            return nums[0] == target ? 0 : -1;

        int lp = 0, rp = len - 1, point = -1;

        for (; ; ) {
            if (lp == rp - 1) {
                point = nums[lp] == target ? lp : nums[rp] == target ? rp : -1;
                break;
            }
            point = (lp + rp) / 2;
            // 如果当前指针下数字小于目标值，就在右数组寻找目标值
            if (nums[point] < target) {
                lp = point;
                continue;
            } else if (nums[point] > target) {
                rp = point;
                continue;
            } else break;
        }
        return point;
    }
}
