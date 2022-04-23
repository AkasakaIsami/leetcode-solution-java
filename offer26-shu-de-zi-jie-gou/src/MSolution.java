/**
 * Created on 2022/4/23 5:09 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null)
            return false;
        return rec(A, B, true);
    }

    public boolean rec(TreeNode A, TreeNode B, boolean isRoot) {
        // 递归终止条件1 B节点全部都在A内
        if (B == null)
            return true;
        // 递归终止条件2 A没能包含B的所有节点
        else if (A == null)
            return false;
        // 递归终止条件3 AB根节点不同
        else if (A.val != B.val && !isRoot)
            return false;

        // 跳过A中节点直到两树根相同
        if (A.val != B.val)
            return rec(A.left, B, true) || rec(A.right, B, true);

        // 相同的根，比较A与B的子树
        boolean result = rec(A.left, B.left, false) && rec(A.right, B.right, false);

        // 如果结果不匹配，继续向下递归
        if (!result) {
            return rec(A.left, B, true) || rec(A.right, B, true);
        }
        return true;
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
