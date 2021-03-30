package solution;

import model.ListNode;

public class LeetCode328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }


        ListNode current = head;
        boolean isOdd = true;
        ListNode lastOdd = head;
        ListNode evenHead = head.next;
        ListNode temp = null;
        while (current != null) {
            if (isOdd) {
                lastOdd = current;
            }
            isOdd = !isOdd;

            temp = current.next;
            if (temp != null) {
                current.next = temp.next;
            }
            current = temp;
        }

        lastOdd.next = evenHead;
        return head;
    }
}
