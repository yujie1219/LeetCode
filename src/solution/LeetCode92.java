package solution;

import model.ListNode;

public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(right == left){
            return head;
        }
        return reverse(head, null, null, left, right, 1);
    }

    private ListNode reverse(ListNode current, ListNode parent, ListNode oldHead, int left, int right, int currentIndex) {
        if (currentIndex < right) {
            if (currentIndex == left) {
                oldHead = current;
            }
            ListNode newHead = reverse(current.next, current, oldHead, left, right, currentIndex + 1);

            if (currentIndex == left) {
                if (parent != null) {
                    parent.next = newHead;
                }
                return newHead;
            } else if (currentIndex < left) {
                return current;
            }

            current.next = parent;
            return newHead;
        }

        if(oldHead != null){
            oldHead.next = current.next;
        }
        current.next = parent;
        return current;
    }
}
