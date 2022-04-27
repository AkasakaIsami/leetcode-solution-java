/**
 * Created on 2022/4/27 5:45 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return rec(root.left, root.right);
    }

    private boolean rec(TreeNode lr, TreeNode rr) {
        // 递归终止条件1 两边都遍历完了
        if (lr == null && rr == null)
            return true;

        // 递归终止条件2 两边不是镜像
        if (lr == null || rr == null)
            return false;

        if (lr.val != rr.val)
            return false;

        return rec(lr.left, rr.right) && rec(lr.right, rr.left);
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
