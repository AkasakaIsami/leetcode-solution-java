/**
 * Created on 2022/4/28 8:59 PM.
 *
 * @author akasakaisami
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */

    List<Integer> nums;
    List<Integer> minIndexs;


    public MinStack() {
        nums = new ArrayList<>();
        minIndexs = new ArrayList<>();
    }

    // 加入元素 要更新元素的minIndex
    public void push(int x) {
        nums.add(x);
        minIndexs.add(0);

        if (nums.size() == 1)
            return;

        int index = nums.size() - 1;
        // 当前数字小于上个数字记录的最小值的话 当前数字最小值索引是自己
        // 当前数字小于上个数字记录的最小值的话 当前数字最小值索引是上个数字记录的最小值
        if (x < nums.get(minIndexs.get(index - 1))) {
            minIndexs.set(index, index);
        } else minIndexs.set(index, minIndexs.get(index - 1));
    }

    public void pop() {
        if (nums.size() != 0) {
            minIndexs.remove(nums.size() - 1);
            nums.remove(nums.size() - 1);
        }
    }

    public int top() {
        if (nums.size() != 0)
            return nums.get(nums.size() - 1);
        else return 0;
    }

    public int min() {
        if (nums.size() != 0)
            return nums.get(minIndexs.get(nums.size() - 1));
        else return 0;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();

    }
}

