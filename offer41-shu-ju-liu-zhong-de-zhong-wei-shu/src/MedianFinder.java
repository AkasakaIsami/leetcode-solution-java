import java.util.ArrayList;

/**
 * Created on 2022/5/24 2:42 PM.
 *
 * @author akasakaisami
 * @URL https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 */
// 大小顶堆的解法本摆子懒得看，有没有小聪明教一下
public class MedianFinder {

    /**
     * initialize your data structure here.
     */

    ArrayList<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    // 二分查找到可以插入的位置
    // 插入复杂度O(logn)
    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
            return;
        }


        int lp = 0, rp = list.size() - 1;

        if (list.get(lp) > num) {
            list.add(lp, num);
            return;
        }

        if (list.get(rp) < num) {
            list.add(rp + 1, num);
            return;
        }
        int medium;
        while (lp <= rp) {
            // 循环终止条件：左右指针相邻，且左值小于插入值
            if (lp == rp - 1) {
                list.add(rp, num);
                break;
            }

            // 循环终止条件：左右指针相撞
            if (lp == rp) {
                if (list.get(lp) > num)
                    list.add(lp, num);
                else list.add(lp + 1, num);
                break;
            }

            medium = (lp + rp) / 2;
            //中位数等于插入值，直接插入

            if (list.get(medium) == num) {
                list.add(medium, num);
                break;
                //中位数小于插入值，插入值属于右边，lp向右移动
            } else if (list.get(medium) < num) {
                lp = medium;
                //中位数小于插入值，插入值属于左边，rp向左移动
            } else {
                rp = medium;
            }
        }


    }

    // 由于内部排序好了，直接返回中间的数字
    // 查询复杂度O(1)
    public double findMedian() {
        if (list.isEmpty())
            return 0;
        int size = list.size();
        if (size % 2 == 0)
            return (double) ((list.get(size / 2 - 1) + list.get(size / 2))) / 2;
        else return list.get(size / 2);
    }


    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());

    }
}
