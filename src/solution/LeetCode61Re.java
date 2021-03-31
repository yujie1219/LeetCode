package solution;

import model.ListNode;

public class LeetCode61Re {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        return rotateRight(head, head, new int[]{k}, 1);
    }

    private ListNode rotateRight(ListNode current, ListNode oldHead, int[] k, int length) {
        if (current.next == null) {
            if (k[0] >= length) {
                k[0] = k[0] % length;
            }

            if (k[0] == 0) {
                k[0] = -2;
                return current;
            }

            current.next = oldHead;
            k[0] = k[0] - 1;
            return current;
        } else {
            ListNode newHead = rotateRight(current.next, oldHead, k, length + 1);

            if (k[0] == 0) {
                current.next = null;
                k[0] = k[0] - 1;
                return newHead;
            } else if (k[0] == -1) {
                return newHead;
            } else {
                k[0] = k[0] - 1;
                return current;
            }
        }
    }

}
