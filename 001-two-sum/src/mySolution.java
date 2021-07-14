/**
 * @author Akasaka Isami
 * @createDate 2021/7/14 12:47 PM
 */

public class mySolution {

 /**
  * @solution1 my solution
  * @description 嵌套循环暴力破解，时间复杂度O(n^2)
  */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

}
