package solution;

import model.ListNode;

public class LeetCode148Re {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        ListNode result = new LeetCode148Re().sortList(head);
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode parent = null;
        ListNode current = head;
        ListNode newHead = head;

        while (current.next != null) {
            boolean runExec = false;
            while (current.next != null && current.val > current.next.val) {
                if (parent == null) {
                    newHead = current.next;
                    parent = current.next;
                } else {
                    parent.next = current.next;
                    parent = parent.next;
                }

                ListNode child = current.next.next;
                current.next.next = current;
                current.next = child;

                runExec = true;
            }

            if (runExec) {
                parent = null;
                current = newHead;
            } else {
                parent = current;
                current = current.next;
            }
        }

        return newHead;
    }
}
