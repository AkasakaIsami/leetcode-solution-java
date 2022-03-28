import java.util.ArrayList;

/**
 * Created on 2022/3/26 7:05 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    int[] record;

    /**
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     *
     * @param n 求解项的index
     * @return 斐波那契（Fibonacci）数列的第 n 项
     */
    public int fib(int n) {
        record = new int[n + 1];
        return rec(n);
    }

    int rec(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;

        if (record[n] != 0)
            return record[n];

        int result = rec(n - 1) + rec(n - 2);
        result %= 1000000007;

        record[n] = result;

        return result;
    }


    public static void main(String[] args) {
        System.out.println(new MSolution().fib(2));
    }
}
