import java.util.*;

/**
 * Created on 2022/5/4 3:36 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        // 双端队列 奇数在右偶数在左 中间是null
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        deque.offerLast(root);
        deque.offerLast(null);


        // 层数奇偶控制：true奇 false偶
        // 奇数层和偶数层进队的方式不同，取当前元素的方式也不同
        boolean isOdd = true;

        List<Integer> tempList = new ArrayList<>();
        TreeNode temp;
        while (true) {
            if (isOdd)
                temp = deque.pollFirst();
            else temp = deque.pollLast();

            // 取到的元素不是null，继续添加元素至当前数组tempList
            // 同时向队列另一段添加元素
            if (temp != null) {
                tempList.add(temp.val);

                if (isOdd) {
                    if (temp.left != null) deque.offerLast(temp.left);
                    if (temp.right != null) deque.offerLast(temp.right);
                } else {
                    if (temp.right != null) deque.offerFirst(temp.right);
                    if (temp.left != null) deque.offerFirst(temp.left);
                }
                // 取到的元素是null，该层结束，当前数组添加到结果数组
            } else {
                result.add(tempList);
                if (deque.size() == 0)
                    // 结束条件 队列里没有元素
                    break;
                tempList = new ArrayList<>();
                if (isOdd) {
                    deque.offerFirst(null);
                    isOdd = false;
                } else {
                    deque.offerLast(null);
                    isOdd = true;
                }
            }
        }
        return result;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}