/**
 * Created on 2022/3/28 10:41 AM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        if (len == 1)
            return numbers[0];


        int lp = 0, rp = len - 1, point = -1;
        while (lp < rp) {
            point = (lp + rp) / 2;
            // 中指针值大于右指针值，说明最小值在右，左指针右移
            if (numbers[rp] < numbers[point]) {
                lp = point + 1;
                // 中指针值小于右指针值，说明最小值在左，右指针左移
            } else if (numbers[rp] > numbers[point]) {
                rp = point;
            } else if (numbers[rp] == numbers[point]) {
                rp--;
            }
        }
        return numbers[lp];
    }

}
