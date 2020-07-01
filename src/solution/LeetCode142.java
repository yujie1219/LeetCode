package solution;

import model.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> node = new HashSet<>();

        while (head != null) {
            if (node.contains(head)) {
                return head;
            } else {
                ListNode current = head;
                node.add(current);
                head = head.next;
            }
        }

        return null;
    }
}
