/**
 * Created on 2022/4/5 1:20 AM.
 *
 * @author akasakaisami
 */
public class MSolution {
    int maxDepth = 0;
    int depth = 0;

    public int maxDepth(TreeNode root) {
        int depth = 0;
        dfs(root, depth);
        return maxDepth;
    }

    void dfs(TreeNode root, int curDepth) {
        if (root == null)
            return;

        curDepth++;
        // 到达叶子节点后回溯并更新max值
        if (root.right == null && root.left == null) {
            maxDepth = curDepth > maxDepth ? curDepth : maxDepth;
        }
        dfs(root.left, curDepth);
        dfs(root.right, curDepth);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}