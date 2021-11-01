import java.util.HashMap;
import java.util.Map;

/**
 * @author Akasaka Isami
 * @createDate 2021/11/1 7:39 PM
 */

public class MSolution {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                return num;
            map.put(num, Boolean.TRUE);
        }
        return -1;
    }
}
