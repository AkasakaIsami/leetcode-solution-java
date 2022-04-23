/**
 * Created on 2022/4/23 4:04 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public ListNode reverseList(ListNode head) {
        // 空链表情况
        if (head == null)
            return null;

        ListNode p1 = head;
        ListNode p2 = p1.next;

        // 单节点情况
        if (p2 == null)
            return p1;

        ListNode p3 = p2.next;
        // 双节点情况
        if (p3 == null) {
            p2.next = p1;
            p1.next = null;
            return p2;
        }

        p1.next = null;

        while (p3 != null) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;

        }

        p2.next = p1;
        return p2;
    }


}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
