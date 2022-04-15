import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2022/4/11 3:38 AM.
 *
 * @author akasakaisami
 */

/**
 * 二分的写法，循环的乘是不行的！
 * 超出时间限制
 */
public class MSolution1 {
    /**
     * 思路是对幂数做因数分解找到底数和幂数
     * 例如求10^40时，对幂40进行因数分解为 2*2*2*5
     * 将求10^40的问题简化为 [10^5]^(2^3)，其中：
     * 1. 底数的底数是题目提供的底数
     * 2. 底数的幂是因数分解的最后一项
     * 3. 幂的幂是因数分解中2的数量
     * 由此，问题被分解为了求三组幂
     * 为了保证不超时，不能用循环
     *
     * @param x 底数
     * @param n 幂
     * @return 幂运算求解结果
     */
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;

        int count = 0, temp = n < 0 ? -n : n;

        while (temp % 2 == 0) {
            count++;
            temp >>= 1;
        }

        double a = 1, b = 1, c = 1;

        for (int i = 0; i < temp; i++)
            a *= x;

        for (int j = 0; j < count; j++)
            b *= 2;

        for (int k = 0; k < b; k++)
            c *= a;

        if (n < 0)
            return 1 / c;
        else
            return c;
    }

}
