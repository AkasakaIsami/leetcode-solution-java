import java.util.*;

/**
 * Created on 2022/5/1 7:13 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root==null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);



        TreeNode temp;
        List<Integer> tempList = new ArrayList<>();
        // 用于判断是否连续两个null
        boolean flag=false;
        while (true) {
            temp = queue.poll();
            // 没取到null 表示该层还在遍历 入队新元素
            if (temp != null) {
                flag=false;
                tempList.add(temp.val);
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            } else {
                // 取到null
                // case1 连续两个null，遍历结束
                if (flag)
                    break;
                // case2 表示该层遍历完 写入结果数组
                else {
                    result.add(tempList);
                    tempList = new ArrayList<>();
                    queue.offer(null);
                    flag=true;
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
