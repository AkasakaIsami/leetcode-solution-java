/**
 * Created on 2022/4/11 2:37 AM.
 *
 * @author akasakaisami
 */
public class MSolution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++)
            count += (n >> i) & 1;
        return count;
    }
}
