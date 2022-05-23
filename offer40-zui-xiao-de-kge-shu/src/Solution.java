/**
 * Created on 2022/5/23 4:42 PM.
 *
 * @author akasakaisami
 * @URL https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 */
public class Solution {
    // 快排 nlogn时间复杂度
    // 参考的这个答案：https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/solution/jian-zhi-offer-40-zui-xiao-de-k-ge-shu-j-9yze/
    public int[] getLeastNumbers(int[] arr, int k) {
        int lp = 0, rp = arr.length - 1;

        quickSort(arr, lp, rp, k);
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private void quickSort(int[] arr, int lp, int rp, int k) {
        // 递归终止条件：左右指针重合
//        if (lp >= rp)
//            return;

        // 优化后递归终止条件：右指针落在k-1上
        if (rp == k - 1 || lp == k + 1 || lp >= rp)
            return;

        // 递归进行逻辑
        // 认定左指针的数字是哨兵
        int pivot = arr[lp];

        // 定义当前用于快排的左右指针
        int llp = lp, rrp = rp, temp;

        // 快排核心思想：比pivot小的放左边，比pivot大的放左边，
        while (llp < rrp) {
            // 这里左右指针哪个先移有说法！因为要保证最后和pivot交换的值要小于pivot
            // 右指针左移
            while (llp < rrp && arr[rrp] >= pivot) rrp--;
            // 左指针右移
            while (llp < rrp && arr[llp] <= pivot) llp++;


            // 交换左右指针的值
            temp = arr[llp];
            arr[llp] = arr[rrp];
            arr[rrp] = temp;
        }


        temp = arr[llp];
        arr[llp] = arr[lp];
        arr[lp] = temp;

        // 不需要两边都执行 如果左数组大于等于k个元素，只跑左边就行
        if (llp>k)
        quickSort(arr, lp, llp - 1, k);
        else {
            quickSort(arr, lp, llp - 1, k);
            quickSort(arr, llp + 1, rp, k);
        }
    }

}
