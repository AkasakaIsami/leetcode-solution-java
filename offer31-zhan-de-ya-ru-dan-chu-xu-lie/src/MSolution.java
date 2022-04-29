import java.util.Stack;

/**
 * Created on 2022/4/29 5:58 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int p1 = 0, p2 = 0, len = pushed.length;
        Stack<Integer> stack = new Stack<>();

        while (true) {
            // 判断p1是否到末尾
            if (p1 == len) {
                // 栈空且p2到末尾 说明匹配
                if (stack.empty() && p2 == len)
                    break;

                // 栈顶与p2当前值是否一致
                if (stack.peek() == popped[p2]) {
                    stack.pop();
                    p2++;
                } else return false;
            } else {
                // 栈顶与p2当前值是否一致
                // 一致的话，移除栈顶，p2向后移动
                if (!stack.empty() && stack.peek() == popped[p2]) {
                    stack.pop();
                    p2++;
                } else {
                    // 不一致的话，向后移动p1并推入栈
                    stack.push(pushed[p1]);
                    p1++;
                }
            }
        }
        return true;
    }


}
