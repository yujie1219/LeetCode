package solution;

import model.ListNode;

public class LeetCode86 {
    public static void main(String[] args) {
        ListNode head = createListNode(2);
        head.next = createListNode(1);
//        head.next.next = createListNode(3);
//        head.next.next.next = createListNode(2);
//        head.next.next.next.next = createListNode(5);
//        head.next.next.next.next.next = createListNode(2);

        LeetCode86 leetCode86 = new LeetCode86();
        leetCode86.partition(head, 3);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode targetParent = null;
        ListNode target = head;
        while (target != null && target.val < x) {
            targetParent = target;
            target = target.next;
        }

        ListNode currentParent = targetParent;
        ListNode current = target;
        while (current != null) {
            if (current.val < x) {
                if (targetParent != null) {
                    targetParent.next = current;
                } else {
                    head = current;
                }
                targetParent = current;
                currentParent.next = current.next;
                current.next = target;
                current = currentParent.next;
            } else {
                currentParent = current;
                current = current.next;
            }
        }

        return head;
    }

    private static ListNode createListNode(int val) {
        return new ListNode(val);
    }
}
