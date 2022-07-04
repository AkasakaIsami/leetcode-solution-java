/**
 * @author Akasaka Isami
 * @description
 * @date 2022-07-04 10:04:04
 * @URL
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] cs = s.toCharArray();
        StringBuilder result = new StringBuilder();

        int p, len = cs.length;
        for (p = n; p < len; p++) {
            result.append(cs[p]);
        }

        for (p = 0; p < n; p++) {
            result.append(cs[p]);
        }

        return result.toString();
    }
}
