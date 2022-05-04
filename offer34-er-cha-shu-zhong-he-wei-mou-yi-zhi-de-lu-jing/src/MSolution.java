import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2022/5/4 6:59 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    TreeNode root;

    // DFS回溯
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null)
            return new ArrayList<>();
        this.root = root;
        List<List<Integer>> result = new ArrayList<>();
        rec(root, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void rec(TreeNode tempNode, int tempSum, int target, List<Integer> list, List<List<Integer>> result) {
        tempSum += tempNode.val;
        list.add(tempNode.val);

        // 终止条件1 到达叶子节点且数值相同
        if (tempNode.left == null && tempNode.right == null) {
            if (tempSum == target) {
                //有一种case不能加，根节点1本身作为叶子节点的情况
                if (list.size() == 1 && (root.left != null && root.right != null))
                    return;
                result.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        if (tempNode.left != null) rec(tempNode.left, tempSum, target, list, result);
        if (tempNode.right != null) rec(tempNode.right, tempSum, target, list, result);


        list.remove(list.size() - 1);
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
