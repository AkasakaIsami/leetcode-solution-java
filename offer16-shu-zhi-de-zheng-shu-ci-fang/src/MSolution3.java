/**
 * Created on 2022/4/15 9:42 AM.
 *
 * @author akasakaisami
 */

/**
 * 处理奇数幂的时候不再需要把奇数幂单独拿出来递归…………
 */
public class MSolution3 {
    public double myPow(double x, int n) {
        return n == 0 ? 1 : n > 0 ? rec(x, n) : 1 / rec(x, -n);
    }

    private double rec(double x, int n) {
        if (n == 0)
            return 1;
        double res = rec(x, n / 2);
        return n % 2 == 0 ? res * res : res * res * x;
    }

    public static void main(String[] args) {
        System.out.println(new MSolution3().myPow(10,4));
    }
}
