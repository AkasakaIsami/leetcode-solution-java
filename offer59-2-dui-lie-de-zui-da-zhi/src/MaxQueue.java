import java.util.Deque;
import java.util.LinkedList;

/**
 * 维护两个队列：一个是正常队列，还有一个单调队列用来记录最大值。
 * <p>You can check the problem detail on <a href="https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/">Leetcode</a>.</p>
 *
 * @author Akasaka Isami
 * @since 2022/7/9 10:04 PM
 */
public class MaxQueue {

    /**
     * 存储所有元素的队列，O(1)pop和push的时间复杂度
     */
    private Deque<Integer> queue;

    /**
     * 有序队列，维护一个单调队列记录元素排序
     */
    private Deque<Integer> orderedQueue;

    public MaxQueue() {
        queue = new LinkedList<>();
        orderedQueue = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty())
            return -1;

        return orderedQueue.getFirst();
    }

    public void push_back(int value) {
        queue.addLast(value);

        // 数字推入有序队列
        if (orderedQueue.isEmpty()) {
            orderedQueue.addLast(value);
            return;
        }
        int max = orderedQueue.getFirst(), min = orderedQueue.getLast();

        if (value > max) {
            // 如果比最大值大，清空有序数组
            orderedQueue.clear();
            orderedQueue.addLast(value);
        } else if (value <= min) {
            // 如果比最小值小，直接加入
            orderedQueue.addLast(value);
        } else {
            // 如果介于中间，直接覆盖掉比自己小的所有元素
            while (value > orderedQueue.getLast()) {
                orderedQueue.removeLast();
            }
            orderedQueue.addLast(value);
        }
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;

        int head = queue.removeFirst();
        if (head == orderedQueue.getFirst()) {
            orderedQueue.removeFirst();
        }

        return head;
    }
}
