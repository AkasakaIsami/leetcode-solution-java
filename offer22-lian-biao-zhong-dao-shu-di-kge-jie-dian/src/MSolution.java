/**
 * Created on 2022/4/22 3:46 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // p1快，p2慢
        ListNode p1 = head, p2 = head;

        for (int i = 0; i < k; i++)
            p1 = p1.next;

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

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
