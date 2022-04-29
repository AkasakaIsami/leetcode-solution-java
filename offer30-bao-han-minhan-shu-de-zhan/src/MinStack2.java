import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on 2022/4/29 4:54 PM.
 *
 * @author akasakaisami
 */
public class MinStack2 {

    /**
     * initialize your data structure here.
     */
    Deque<Integer> nums;
    Deque<Integer> mins;

    public MinStack2() {
        nums = new LinkedList<>();
        mins = new LinkedList<>();
    }

    public void push(int x) {
        nums.push(x);

        if (nums.size() == 1)
            mins.push(x);
        else {
            if (x < mins.getFirst())
                mins.push(x);
            else
                mins.push(mins.getFirst());
        }
    }

    public void pop() {
        if (nums.size() != 0) {
            nums.pop();
            mins.pop();
        }
    }

    public int top() {
        if (nums.size() != 0) {
            return nums.getFirst();
        }else return 0;
    }

    public int min() {
        if (mins.size() != 0) {
            return mins.getFirst();
        }else return 0;
    }


    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();

    }
}
