package solution;

import model.ListNode;

public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }

        ListNode first = head.next;
        ListNode second = head.next.next;

        while (second != null && first != second) {
            first = first.next;
            if (second.next != null) {
                second = second.next.next;
            } else {
                return false;
            }
        }

        if (second == null) {
            return false;
        }

        return true;
    }
}
