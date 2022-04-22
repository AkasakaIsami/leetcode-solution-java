/**
 * Created on 2022/4/20 1:05 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public int[] exchange(int[] nums) {
        int len = nums.length;

        if (len == 0)
            return nums;

        int lp = 0, rp = len - 1, temp = -1;

        while (lp != rp) {
            // 左偶右奇
            if (nums[lp] % 2 == 0 && nums[rp] % 2 != 0) {
                temp = nums[lp];
                nums[lp] = nums[rp];
                nums[rp] = temp;
                // 左奇
            } else if ((nums[lp] & 1) == 1)
                lp++;
                // 右偶
            else if ((nums[rp] & 1) == 0)
                rp--;
        }

        return nums;
    }


    public int[] exchange2(int[] nums) {
        int len = nums.length;
        int lp = 0, rp = len - 1;
        int[] result = new int[len];

        for (int num : nums) {
            if (num % 2 != 0) {
                result[lp] = num;
                lp++;
            } else {
                result[rp] = num;
                rp--;
            }
        }
        return result;
    }
}
