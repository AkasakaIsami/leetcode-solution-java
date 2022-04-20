/**
 * Created on 2022/4/20 11:08 AM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public boolean isNumber(String s) {
        char[] ss = s.toCharArray();

        boolean result = false;
        // 定义遍历字符串的指针
        int p = 0;

        // 定义判断是否为整数或小数的窗口指针
        int lp = -1, rp = -1;

        // 过滤空格
        while (p < ss.length) {
            if (ss[p] == ' ') {
                p++;
            } else {
                lp = p;
                break;
            }
        }

        // 记录当前判断的是否是e后整数
        boolean isAfterE = false;

        // 找到下一个空格、或者'e'、或直接到达字符串末端
        // 整数or小数 + e + 整数
        while (p < ss.length) {
            if ((ss[p] == ' ' || p == ss.length - 1) && !isAfterE) {
                rp = p;
                result = ss[p] == ' ' ? isInteger(lp, rp, ss) || isDecimal(lp, rp, ss) : isInteger(lp, rp + 1, ss) || isDecimal(lp, rp + 1, ss);
                p++;
                break;
            } else if ((ss[p] == ' ' || p == ss.length - 1) && isAfterE) {
                rp = p;
                result = ss[p] == ' ' ? isInteger(lp, rp, ss) : isInteger(lp, rp + 1, ss);
                p++;
                break;
            } else if ((ss[p] == 'e' || ss[p] == 'E') && !isAfterE) {
                rp = p;
                if (isInteger(lp, rp, ss) || isDecimal(lp, rp, ss)) {
                    isAfterE = true;
                    lp = p + 1;
                } else return false;
            }
            p++;
        }

        // 判断是否后面全是空格
        while (p < ss.length) {
            if (ss[p] != ' ')
                return false;
            p++;
        }

        return result;
    }


    private boolean isInteger(int lp, int rp, char[] ss) {
        if (lp == rp)
            return false;

        int p = lp;

        // 如果第一位是正负号，跳过
        if (ss[p] == '-' || ss[p] == '+')
            p++;

        // 只包含正负号，不是整数
        if (p == rp)
            return false;

        for (; p < rp; p++) {
            if (!(ss[p] >= '0' && ss[p] <= '9'))
                return false;
        }

        return true;
    }


    private boolean isDecimal(int lp, int rp, char[] ss) {
        int p = lp;

        // 如果第一位是正负号，跳过
        if (ss[p] == '-' || ss[p] == '+')
            p++;

        // 小数点出现的次数
        int count1 = 0;
        // 正常数字出现的次数
        int count2 = 0;

        for (; p < rp; p++) {
            if (ss[p] == '.') {
                count1++;
                continue;
            } else if (!(ss[p] >= '0' && ss[p] <= '9'))
                return false;
            count2++;
        }

        // 包含一个小数点和至少一个数字，则是小数
        return count1 == 1 && count2 != 0;
    }
}
