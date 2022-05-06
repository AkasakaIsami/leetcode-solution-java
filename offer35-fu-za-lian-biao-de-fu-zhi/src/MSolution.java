import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2022/5/6 11:48 PM.
 *
 * @author akasakaisami
 */
public class MSolution {
    public Node copyRandomList(Node head) {
        if (head==null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        // 构建哈希表 O(1)查询
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}

/**
 * Definition for a Node.
 **/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
