/**
 * Created on 2022/5/9 9:06 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    Node pre;
    Node first;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        dfs(root);
        first.left = pre;
        pre.right = first;
        return first;
    }

    // 中序遍历
    // 因为中序遍历，先得到小值，要用pre存储前一个小值，再和temp建立关系
    private void dfs(Node temp) {
        if (temp == null)
            return;

        dfs(temp.left);

        // 当前节点执行逻辑
        if (pre == null) {
            // 找到第一个最小节点
            pre = temp;
            first = temp;
        } else {
            // 最小节点可能也有右子节点……不能直接return而是搞一个else分支
            temp.left = pre;
            pre.right = temp;
            pre = temp;
        }

        dfs(temp.right);
    }
}

/**
 * Definition for a Node.
 **/
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
