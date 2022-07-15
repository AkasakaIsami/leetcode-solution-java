/**
 * <p>You can check the problem detail on <a href="https://leetcode.cn/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/">Leetcode</a>.</p>
 *
 * @author Akasaka Isami
 * @since 2022-07-15 20:11:27
 */
public class Solution {
    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val){
            return root;
        }

        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left,p,q);
        else if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);
        else return root;
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
