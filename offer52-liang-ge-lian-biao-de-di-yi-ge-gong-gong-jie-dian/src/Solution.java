/**
 * Created on 2022/6/21 12:28 AM.
 *
 * @author akasakaisami
 * @URL
 */
public class Solution {
    // https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/yi-zhang-tu-jiu-ming-bai-ai-qing-jie-shi-up3a/
    // 这个题解好，比起他花里胡哨的好多了
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            // 循环结束条件 1。pa和pb相同，找到公共节点了 2。pa和pb同时为null，都到屁股了
            // 所以结束条件是pa=pb
            if (pa == null)
                pa = headB;
            else pa = pa.next;

            if (pb == null)
                pb = headA;
            else pb = pb.next;

        }
        return pa;
    }
}

/**
 * Definition for singly-linked list.
 **/


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}