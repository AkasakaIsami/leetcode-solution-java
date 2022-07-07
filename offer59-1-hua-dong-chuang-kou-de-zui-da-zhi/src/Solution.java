import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Akasaka Isami
 * @description
 * @date 2022-07-07 09:37:08
 * @URL https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class Solution {
    // 这个题解不错 https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/solution/dong-hua-yan-shi-dan-diao-dui-lie-jian-z-unpy/
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];

        int[] result = new int[nums.length - k + 1];

        // 定义记录前一个窗口max序列的单调队列
        Deque<Integer> deque = new LinkedList<>();

        // 初始化第一个窗口的队列内容
        deque.offerFirst(0);
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[deque.getFirst()]) {
                // 新元素进队时，如果进队元素比最大值大，清空队列
                deque.clear();
                deque.offerFirst(i);
            } else if (nums[i] < nums[deque.getLast()]) {
                // 如果进队元素比最小值小，直接追加在最后
                deque.offerLast(i);
            }else {
                // 如果进队元素介于两者之间，把小于他的值全踢走，再接到队列屁股后面
                while (nums[i] > nums[deque.getLast()]) {
                    deque.removeLast();
                }
                deque.offerLast(i);
            }
        }

        result[0] = deque.getFirst();

        // 开始遍历所有窗口
        int left = 1;
        for (int i = k; i < nums.length; i++) {
            // 每次遍历，一个元素出窗口，一个元素进窗口
            // 判断出窗口元素是不是目前队列里记录的最大元素
            if (deque.getFirst() < left) {
                deque.removeFirst();
            }

            if (deque.size() == 0)
                deque.offerFirst(i);
            else if (nums[i] > nums[deque.getFirst()]) {
                // 新元素进队时，如果进队元素比最大值大，清空队列
                deque.clear();
                deque.offerFirst(i);
            } else if (nums[i] <= nums[deque.getLast()]) {
                // 如果进队元素比最小值小，直接追加在最后
                deque.offerLast(i);
            } else {
                // 如果进队元素介于两者之间，把小于他的值全踢走，再接到队列屁股后面
                while (nums[i] > nums[deque.getLast()]) {
                    deque.removeLast();
                }
                deque.offerLast(i);
            }

            // 更新当前滑动窗口最大值
            result[i - k + 1] = deque.getFirst();

            left++;
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = nums[result[i]];
        }
        return result;
    }
}
