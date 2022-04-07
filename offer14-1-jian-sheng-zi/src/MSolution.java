/**
 * Created on 2022/4/8 12:59 AM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public int cuttingRope(int n) {
        // 缓存 存储每个点的最大值，但最初始的3个值是含义不同
        int[] maxs = new int[n + 1];

        if (n == 1)
            return 1;
        else if (n == 2)
            return 1;
        else if (n == 3)
            return 2;

        // 长度为1，贡献一种剪法 1
        maxs[1] = 1;
        // 长度为2，贡献两种减法 1 1、2
        maxs[2] = 2;
        // 长度为3，贡献三种减法 1 1 1、1 2、3
        maxs[3] = 3;


        // 状态转移方程：f(i) = max[f(j) * f(i-j)], 其中 j属于(1,n)
        int temp = -1;
        for (int i = 3; i <= n; i++)
            for (int j = 1; j <= i / 2; j++) {
                temp = maxs[j] * maxs[i - j];
                maxs[i] = Math.max(maxs[i], temp);
            }


        return maxs[n];
    }
}
