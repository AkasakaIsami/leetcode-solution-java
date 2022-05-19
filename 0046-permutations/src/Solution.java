import java.util.*;

/**
 * Created on 2022/5/19 3:40 PM.
 *
 * @author akasakaisami
 * @url https://leetcode.cn/problems/permutations/
 */
public class Solution {
    /**
     * 全排列，思路是dfs+回溯
     * 这道题是回溯的经典题目！
     * 控制回溯的方法是状态管理，核心是每次递归都撤销上次对状态的变更
     * 同时状态也能用来控制递归的结束
     * 大概吧……
     * <p>
     * 这道题的设置的状态变量是一个记录当前path的stack，以及记录已经被使用的元素的数组
     */
    public List<List<Integer>> permute(int[] nums) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (size == 0)
            return result;

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[size];
        int depth = 0;
        dfs(path, nums, used, size, depth, result);
        return result;
    }

    private void dfs(Deque<Integer> path, int[] nums, boolean[] used, int size, int depth, List<List<Integer>> result) {
        // 递归终止条件：深度达到所有数字的数量
        // 这种时候used数组里全是true
        if (depth == size) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 递归进行
        // 注意，对于每一个未访问的值，都要进行一次递归
        for (int i = 0; i < size; i++) {
            if (used[i])
                continue;

            // 找到未访问过的数字，加入stack
            path.addLast(nums[i]);
            used[i] = true;
            dfs(path, nums, used, size, depth + 1, result);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permute(new int[]{1, 2, 3});
    }
}
