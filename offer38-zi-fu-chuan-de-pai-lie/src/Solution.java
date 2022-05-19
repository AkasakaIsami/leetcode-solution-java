import java.util.*;

/**
 * Created on 2022/5/18 5:00 PM.
 *
 * @author akasakaisami
 * @url https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class Solution {
    /**
     * dfs回溯
     * 和46.全排列的区别在于可能存在重复字符
     * 题目需要考虑如何去重
     * 放在hashset里去重吧= =
     * 不知道为什么速度很慢，随便吧
     */
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        if (len == 0)
            return new String[len];

        // 因为有重复字符，结果可能有重复，先把结果加在这个set里，再把set里的东西放到数组里
        List<String> list = new ArrayList<>();

        Deque<Character> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        int depth = 0;

        dfs(path, len, depth, chars, used, list);

        String[] result = new String[list.size()];
        return list.toArray(result);
    }

    /**
     * dfs回溯寻找全排列
     *
     * @param path  状态变量1：当前路径，由栈保存
     * @param len   字符数量
     * @param depth 状态变量2：当前深度，用于递归终止条件
     * @param chars 所有字符
     * @param used  状态变量3：记录已使用的字符
     * @param list  存储结果的集合
     */
    private void dfs(Deque<Character> path, int len, int depth, char[] chars, boolean[] used, List<String> list) {
        if (depth == len) {
            list.add(stack2str(path));
            return;
        }

        Set<Character> duplicate = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (used[i])
                continue;
            // 为了避免重复字符，记录下当前字符，再出现的话不对它进行递归
            char temp = chars[i];
            if (duplicate.contains(temp))
                continue;

            path.addLast(chars[i]);
            used[i] = true;
            dfs(path, len, depth + 1, chars, used, list);

            path.removeLast();
            used[i] = false;

            duplicate.add(temp);
        }
    }

    /**
     * 栈内字符转字符串
     *
     * @param path 存储字符的栈
     * @return 转换后的字符串
     */
    private String stack2str(Deque<Character> path) {
        List<Character> temp = new ArrayList<>(path);
        StringBuilder result = new StringBuilder();
        for (Character c : temp) {
            result.append(c);
        }

        return result.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permutation("abc");
    }
}
