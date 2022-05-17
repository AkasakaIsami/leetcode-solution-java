import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created on 2022/5/17 8:52 PM.
 *
 * @author akasakaisami
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();

        // DFS
        dfs1(root, s);
        return s.toString();
    }

    private void dfs1(TreeNode curr, StringBuilder s) {
        // 终止条件 到达叶子节点
        if (curr == null) {
            s.append('#');
            s.append(',');
            return;
        }

        s.append(curr.val);
        s.append(',');

        dfs1(curr.left, s);
        dfs1(curr.right, s);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayList<String> ss = new ArrayList<String>(Arrays.asList(data.split(",")));
        return dfs2(ss);
    }

    // 一个疑问，这个递归代码为什么不用考虑输入ss已经为空的情况？
    private TreeNode dfs2(ArrayList<String> ss) {
        String temp=ss.get(0);
        if (temp.equals("#"))
            return null;

        TreeNode curr=new TreeNode(Integer.parseInt(temp));
        ss.remove(0);
        curr.left=dfs2(ss);
        ss.remove(0);
        curr.right=dfs2(ss);

        return curr;
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        r1.left = r2;
        r1.right = r3;
        r3.left = r4;
        r3.right = r5;
        String s = codec.serialize(r1);
        TreeNode node=codec.deserialize(s);
        System.out.println(node);
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


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
