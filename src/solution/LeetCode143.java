package solution;

import model.ListNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode143 {
    Map<ListNode, ListNode> parent = new HashMap<>();

    public void reorderList(ListNode head) {
        ListNode last = findLast(head);

        ListNode current = head;

        while (current != null) {
            ListNode child = current.next;

            if (current.equals(last) || child.equals(last)) {
                break;
            }
            ListNode lastParent = this.parent.get(last);
            current.next = last;
            last.next = child;
            current = child;
            lastParent.next = null;
            last = lastParent;

            if (child.equals(last)) {
                break;
            }

        }
    }

    private ListNode findLast(ListNode head) {
        ListNode parent = null;
        ListNode current = head;

        while (current != null) {
            this.parent.put(current, parent);
            parent = current;
            current = current.next;
        }

        return parent;
    }
}
