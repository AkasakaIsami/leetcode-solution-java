/**
 * @author Akasaka Isami
 * @createDate 2021/11/3 9:17 AM
 */


public class MSolution {
    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[0];
        int len = 0;
        ListNode p1 = head, p2 = head.next, temp;
        p1.next = null;
        while (p2 != null) {
            len++;
            temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        len++;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (p1 != null) {
                result[i] = p1.val;
                p1 = p1.next;
            }
        }
        return result;
    }
}
