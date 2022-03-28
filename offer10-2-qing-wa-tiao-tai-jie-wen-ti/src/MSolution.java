/**
 * Created on 2022/3/28 10:10 AM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public int numWays(int n) {
        // state transition function: f(n) = f(n-1) + f(n-2)
        if (n==0)
            return 1;
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i < n+1; i++) {
            cache[i] = (cache[i - 1] + cache[i - 2]) % 1000000007;
        }
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(new MSolution().numWays(7));
    }
}
