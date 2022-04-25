/**
 * Created on 2022/4/25 8:08 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public TreeNode mirrorTree(TreeNode root) {
        rec(root);
        return root;
    }

    private void rec(TreeNode node) {
        if (node == null)
            return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        rec(node.left);
        rec(node.right);
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
