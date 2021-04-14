package solution;

import model.ListNode;

public class LeetCode82Re {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return removeDuplicates(head, Integer.MIN_VALUE, new boolean[1]);
    }

    // check[0] means if the value of the last node == current node, # check[1] means if the value of last node occur many times #
    private ListNode removeDuplicates(ListNode current, int lastNum, boolean[] check) {
        if (current.next != null) {
            ListNode lastNode = removeDuplicates(current.next, current.val, check);

            current.next = lastNode;
            if (check[0]) {
                if (lastNum != current.val) {
                    check[0] = false;
                }
                return lastNode;
            } else {
                if (lastNum == current.val) {
                    check[0] = true;
                    return lastNode;
                } else {
                    return current;
                }
            }
        } else {
            if (lastNum == current.val) {
                check[0] = true;
                return null;
            }

            return current;
        }
    }
}
