package solution;

import model.ListNode;

public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        while (lengthA < lengthB) {
            headB = headB.next;
            lengthB--;
        }

        while (lengthB < lengthA) {
            headA = headA.next;
            lengthA--;
        }

        return finResult(headA, headB);
    }

    private int getLength(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            listNode = listNode.next;
            length++;
        }

        return length;
    }

    private ListNode finResult(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        if (headA.next == null && headB.next == null) {
            if (headA.equals(headB)) {
                return headA;
            } else {
                return null;
            }
        } else {
            ListNode result = finResult(headA.next, headB.next);
            return result == null ? null : (headA.equals(headB) ? headA : result);
        }

    }
}
