import java.util.*;

/**
 * Created on 2022/4/30 10:36 AM.
 *
 * @author akasakaisami
 */
public class MSolution {
    // BFS 广度优先遍历
    // 和DFS用递归不同，一般借助一个队列，然后用循环实现
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);

        TreeNode temp;
        while (queue.size() != 0) {
            temp = queue.poll();
            list.add(temp.val);

            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }

        int len = list.size();
        int[] result = new int[len];
        for (int i = 0; i < len; i++)
            result[i] = list.get(i);

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

