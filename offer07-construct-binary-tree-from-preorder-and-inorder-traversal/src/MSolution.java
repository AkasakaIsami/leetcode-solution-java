/**
 * Created on 2022/3/23 7:05 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int size = preorder.length;
        int pre_start = 0, pre_end = size - 1, in_start = 0, in_end = size - 1;
        return recBuildTree(pre_start, pre_end, in_start, in_end);
    }

    private TreeNode recBuildTree(int pre_start, int pre_end, int in_start, int in_end) {
        // 终止条件
        if (pre_start > pre_end || in_start > in_end)
            return null;

        // 在前序中获得root的值，并在中序中获得中序root的索引
        int size = pre_end - pre_start + 1;
        int root = preorder[pre_start], In_root_index = in_start;
        for (int i = 0; i < size; In_root_index++, i++) {
            if (inorder[In_root_index] == root) {
                break;
            }
        }

        // 找到新左子树的长度与首尾index
        int left_len = In_root_index - in_start;

        // 左子树在前序和中序中的首尾
        int left_pre_start = pre_start + 1, left_pre_end = pre_start + left_len;
        int left_in_start = in_start, left_in_end = in_start + left_len - 1;

        // 找到新右子树的长度与首尾index
        int right_len = size - left_len - 1;

        int right_pre_start = left_pre_end + 1, right_pre_end = pre_end;
        int right_in_start = In_root_index + 1, right_in_end = in_end;

        TreeNode temp = new TreeNode(root);
        temp.left = recBuildTree(left_pre_start, left_pre_end, left_in_start, left_in_end);
        temp.right = recBuildTree(right_pre_start, right_pre_end, right_in_start, right_in_end);

        return temp;
    }

    public static void main(String[] args) {
        MSolution m = new MSolution();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode r = m.buildTree(preorder, inorder);
        System.out.println(r);
    }
}
