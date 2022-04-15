/**
 * Created on 2022/4/15 9:59 AM.
 *
 * @author akasakaisami
 */
public class MSolution4 {
    public double myPow(double x, int n) {
        int power = n;
        if (n == 0)
            return 1;
        else if (n < 0)
            n = -n;

        // 累加存储计算结果
        double res = 1;

        // 记录当前幂计算结果
        double temp = x;

        while (n != 0) {
            // n末位是1，需要累加到结果
            if ((n & 1) == 1) {
                res = res * temp;
            }

            temp *= temp;

            n >>= 1;
        }

        return power > 0 ? res : 1 / res;
    }

    public static void main(String[] args) {
        System.out.println(new MSolution3().myPow(2, -2));
    }
}
