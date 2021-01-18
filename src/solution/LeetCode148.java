package solution;

import model.ListNode;

public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        int length = getLength(head);

        ListNode tmpHead = head;
        for (int i = 1; i < length; i++) {
            ListNode parent = null;
            ListNode current = tmpHead;

            while (current != null) {
                if (current.next != null) {
                    if (current.val > current.next.val) {
                        if (parent == null) {
                            tmpHead = current.next;
                            current.next = current.next.next;
                            tmpHead.next = current;

                            parent = tmpHead;
                        } else {
                            ListNode child = current.next;
                            current.next = current.next.next;
                            child.next = current;
                            parent.next = child;

                            parent = child;
                        }
                    } else {
                        if (parent == null) {
                            tmpHead = current;
                        }
                        parent = current;
                        current = current.next;
                    }
                } else {
                    break;
                }
            }
        }

        return tmpHead;
    }

    private int getLength(ListNode head) {
        ListNode tmpHead = head;
        int i = 0;
        while (tmpHead != null) {
            i++;
            tmpHead = tmpHead.next;
        }

        return i;
    }
}
