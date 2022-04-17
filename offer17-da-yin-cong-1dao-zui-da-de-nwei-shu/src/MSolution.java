/**
 * Created on 2022/4/15 10:47 AM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
