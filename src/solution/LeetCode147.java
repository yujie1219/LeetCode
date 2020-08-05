package solution;

import model.ListNode;

public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode sortedHead = head;
        head = head.next;
        sortedHead.next = null;

        while (head != null) {
            ListNode insert = head;
            head = head.next;

            sortedHead = insertListNode(sortedHead, insert);
        }

        return sortedHead;
    }

    private ListNode insertListNode(ListNode sorted, ListNode insert) {
        ListNode parent = null;
        ListNode current = sorted;

        while (current != null) {
            if (parent == null && insert.val <= current.val) {
                insert.next = sorted;
                return insert;
            } else if (parent != null && insert.val > parent.val && insert.val <= current.val) {
                parent.next = insert;
                insert.next = current;
                return sorted;
            }

            parent = current;
            current = current.next;
        }

        insert.next = null;
        parent.next = insert;
        return sorted;
    }
}
