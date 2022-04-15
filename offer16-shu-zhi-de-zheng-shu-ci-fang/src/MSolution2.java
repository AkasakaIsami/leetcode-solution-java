import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2022/4/15 9:37 AM.
 *
 * @author akasakaisami
 */

/**
 * 递归的写法
 * 超出时间限制
 * 每次递归都调用两次递归……
 */
public class MSolution2 {
    Map<Integer, Double> record = new HashMap();

    public double myPow(double x, int n) {
        return n == 0 ? 1 : n > 0 ? rec(x, n) : 1 / rec(x, -n);
    }


    public double rec(double x, int n) {
        if (n == 1)
            return x;
        if (n == 2)
            return x * x;
        double temp = 0;

        if (record.containsKey(n / 2) && record.containsKey(n - n / 2))
            temp = record.get(n / 2) * record.get(n - n / 2);
        else if (record.containsKey(n / 2))
            temp = record.get(n / 2) * myPow(x, n - n / 2);
        else if (record.containsKey(n - n / 2))
            temp = myPow(x, n / 2) * record.get(n - n / 2);
        else temp = myPow(x, n / 2) * myPow(x, n - n / 2);

        record.put(n, temp);
        return temp;
    }

}
