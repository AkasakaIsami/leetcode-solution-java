import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2022/5/23 4:11 PM.
 *
 * @author akasakaisami
 */
public class Vote {
    // 参考的这个网址的教学：https://www.bilibili.com/video/BV1it411V784?spm_id_from=333.337.search-card.all.click
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int lp = 0, rp = len - 1;
        int candidate = nums[lp];

        // 计数器，小于0以后换candidate
        int count = 0;
        int left, right;
        while (lp <= rp) {

            //每两个为一组去看
            left = nums[lp];
            right = nums[rp];

            // count为0的话，更新candidate
            if (count == 0)
                candidate = left;

            // 相等,且值就是candidate，计数器加一
            if (left == right) {

                count = candidate == left ? count + 1 : count - 1;

                // 更新count后，若小于0，则更新candidate
                if (count < 0)
                    candidate = left;
            }
            lp++;
            rp--;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new Vote().majorityElement(new int[]{6, 5, 5}));
    }
}
