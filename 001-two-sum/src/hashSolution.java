import java.util.HashMap;
import java.util.Map;

/**
 * @author Akasaka Isami
 * @createDate 2021/7/14 12:53 PM
 */

public class hashSolution {

    /**
     * @solution2 hashmap solution
     * @description 哈希表存储访问过的元素，每访问一次，判断哈希表是否有与其匹配的存储，时间复杂度O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        int length = nums.length;
        int tempNum;
        for (int i = 0; i < length; i++) {
            tempNum = nums[i];
            if (map.containsKey(target - tempNum)) {
                result[0] = map.get(target - tempNum);
                result[1] = i;
                return result;
            }
            map.put(tempNum, i);
        }
        return null;
    }

}
