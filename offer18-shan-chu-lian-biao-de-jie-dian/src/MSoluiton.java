/**
 * Created on 2022/4/17 1:04 PM.
 *
 * @author akasakaisami
 */
public class MSoluiton {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode temp = dummy;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next= temp.next.next;
                break;
            }
            temp = temp.next;
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}