/**
 * @author Akasaka Isami
 * @description
 * @date 2022-06-27 10:14:34
 * @URL https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/
 */
public class Solution {

    // 记录是否为平衡二叉树
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }

    /**
     * 递归遍历 可以这样遍历结束了 时间复杂度不应该很垃圾吗
     * 找到使得flag为false的情况马上break不好吗
     *
     * @param root 当前树根节点
     * @return 当前树深度
     */
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int depthLeft = dfs(root.left);
        int depthRight = dfs(root.right);

        if (Math.abs(depthLeft - depthRight) > 1) {
            flag = false;
        }

        return depthLeft > depthRight ? depthLeft + 1 : depthRight + 1;
    }
}

/**
 * Definition for a binary tree node.
 **/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}