/**
 * Created on 2022/5/4 4:38 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public boolean verifyPostorder(int[] postorder) {
        return postorder.length == 0 || rec(0, postorder.length - 1, postorder);
    }

    /**
     * 当前窗口下的树是否是bst
     * @param lp 窗口左索引
     * @param rp 窗口右索引
     * @param postorder 树
     * @return 当前窗口下的树是否是bst
     */
    private boolean rec(int lp, int rp, int[] postorder) {
        // 合格二叉搜索树的条件：左子树最大值 < 根值 < 右子树最小值

        // 终止条件1 左右指针相遇
        if (lp == rp || lp == rp - 1)
            return true;

        int root = postorder[rp];

        int index = lp, i;
        // 找到左右子树交界点，即交界点左边的值都小于root，右边的值都大于root
        for (i = lp; i < rp; i++) {
            if (postorder[i] > root) {
                index = i;
                break;
            }
        }

        // 终止条件2 找不到交界点
        for (; i < rp; i++) {
            if (postorder[i] < root)
                return false;
        }

        // 递归传递
        if (lp == index)
            return rec(index, rp - 1, postorder);
        else return rec(lp, index - 1, postorder) && rec(index, rp - 1, postorder);
    }
}
