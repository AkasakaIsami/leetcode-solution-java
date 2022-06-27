/**
 * @author Akasaka Isami
 * @description
 * @date 2022-06-27 09:59:56
 * @URL https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 */
public class Solution {

    int result, k;

    // 右 根 左 的反向中序遍历
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        // recursion 终止条件
        if (k < 0 || root == null)
            return;

        dfs(root.right);

        // recursion body
        k--;
        if (k == 0) {
            result = root.val;
        }

        dfs(root.left);
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

