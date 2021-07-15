/**
 * @author Akasaka Isami
 * @createDate 2021/7/15 10:10 AM
 */

public class mySolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy1 = new ListNode(0, l1);
        ListNode dummy2 = new ListNode(0, l2);
        ListNode dummy3 = new ListNode(0, null);

        ListNode temp1 = dummy1;
        ListNode temp2 = dummy2;
        ListNode temp3 = dummy3;

        int tempVal = 0;
        for (; temp1.next != null || temp2.next != null; temp1 = temp1.next, temp2 = temp2.next, temp3 = temp3.next) {

            if (temp1.next == null && temp2.next != null)
                temp1.next = new ListNode(0, null);
            else if (temp2.next == null && temp1.next != null)
                temp2.next = new ListNode(0, null);

            tempVal = temp1.val + temp2.val;
            temp3.val = temp3.val == 0 ? tempVal : tempVal + 1;
            if (temp3.val < 10) {
                temp3.next = new ListNode(0, null);
                if (temp1.next == null && temp2.next == null)
                    temp3.next = null;
            } else {
                temp3.val = temp3.val - 10;
                temp3.next = new ListNode(1, null);
            }
        }
        temp3.val += temp1.val + temp2.val;
        if (temp3.val > 9) {
            temp3.val -= 10;
            temp3.next = new ListNode(1, null);
        }
        return dummy3.next;
    }
}


