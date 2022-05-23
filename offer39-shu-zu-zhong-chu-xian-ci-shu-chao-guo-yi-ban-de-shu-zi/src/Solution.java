import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2022/5/19 11:36 PM.
 *
 * @author akasakaisami
 * @url https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int size = nums.length;

        if (size==1)
            return nums[0];

        Map<Integer, Integer> counter = new HashMap<>();
        for (int temp : nums) {
            if (!counter.containsKey(temp))
                counter.put(temp, 1);
            else {
                counter.put(temp, counter.get(temp) + 1);
                if (counter.get(temp)>size/2)
                    return temp;
            }
        }
        return -1;
    }
}
