import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2022/5/30 9:57 PM.
 *
 * @author akasakaisami
 * @URL https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class Solution {
    public char firstUniqChar(String s) {
        if (s.equals(""))
            return ' ';

        char[] cs = s.toCharArray();

        Set<Character> setForOneTimeOccurrence = new HashSet<>(), setForOthers = new HashSet<>();

        for (char c : cs) {
            if (!setForOneTimeOccurrence.contains(c) && !setForOthers.contains(c)) {
                // 从未出现过的字符
                setForOneTimeOccurrence.add(c);
            } else if (setForOneTimeOccurrence.contains(c) && !setForOthers.contains(c)) {
                // 只出现过一次的字符
                setForOneTimeOccurrence.remove(c);
                setForOthers.add(c);
            }
            // 出现过多次的字符 do nothing
        }

        for (char c : cs)
            if (setForOneTimeOccurrence.contains(c))
                return c;

        return ' ';
    }
}
