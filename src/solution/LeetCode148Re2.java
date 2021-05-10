package solution;

import model.ListNode;

import java.util.List;

public class LeetCode148Re2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        ListNode result = new LeetCode148Re2().sortList(head);
    }

    public ListNode sortList(ListNode head) {
        ListNode sorted = null;
        if (head != null) {
            sorted = sortList(head, null);
        }

        return sorted;
    }

    private ListNode sortList(ListNode start, ListNode end) {
        int length = getLength(start, end);

        if (length == 1) {
            start.next = null;
            return start;
        }

        int middle = length / 2;
        ListNode mid = start;
        while (middle > 0) {
            mid = mid.next;
            middle--;
        }

        ListNode node1 = sortList(start, mid);
        ListNode node2 = sortList(mid, end);

        ListNode merged = merge(node1, node2);

        return merged;
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode merged = new ListNode();

        ListNode current = merged;
        while (n1 != null || n2 != null) {
            ListNode n = n1 == null ? n2 : (n2 == null ? n1 : (n1.val < n2.val ? n1 : n2));
            current.next = n;
            if (n.equals(n1)) {
                n1 = n1.next;
            } else {
                n2 = n2.next;
            }
            current = current.next;
        }

        return merged.next;
    }

    private int getLength(ListNode start, ListNode end) {
        ListNode current = start;
        int length = 0;
        while (current != end) {
            length++;
            current = current.next;
        }

        return length;
    }
}
