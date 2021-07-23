/**
 * @author Akasaka Isami
 * @createDate 2021/7/23 9:55 AM
 */

public class MySolution {
    public int climbStairs(int n) {
        // State-transition equation：f(n)=f(n-1)+f(n-2)

        // Array that store the past result that would be reused
        int[] results = new int[n];

        // Caculate from small to large
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                results[i] = 1;
                continue;
            } else if (i == 1) {
                results[i] = 2;
                continue;
            }
            // State transition
            results[i] = results[i - 1] + results[i - 2];
        }
        return results[n-1];
    }

}
