/**
 * @author Akasaka Isami
 * @createDate 2021/7/15 10:14 AM
 */

public class ListNode {
    /**
     * Definition for singly-linked list.
     */
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
