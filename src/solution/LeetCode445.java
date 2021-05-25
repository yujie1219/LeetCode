package solution;

import model.ListNode;

import java.util.List;
import java.util.Stack;

public class LeetCode445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int jinwei = 0;
        ListNode head = new ListNode();
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int n1 = s1.pop();
            int n2 = s2.pop();

            int val = n1 + n2 + jinwei;
            jinwei = val / 10;
            int actVal = val % 10;
            if (head.next == null) {
                head.next = new ListNode(actVal);
            } else {
                ListNode next = new ListNode(actVal);
                next.next = head.next;
                head.next = next;
            }
        }

        while (!s1.isEmpty()) {
            int n1 = s1.pop() + jinwei;
            jinwei = n1 / 10;
            int actVal = n1 % 10;
            if (head.next == null) {
                head.next = new ListNode(actVal);
            } else {
                ListNode next = new ListNode(actVal);
                next.next = head.next;
                head.next = next;
            }
        }

        while (!s2.isEmpty()) {
            int n2 = s2.pop() + jinwei;
            jinwei = n2 / 10;
            int actVal = n2 % 10;
            if (head.next == null) {
                head.next = new ListNode(actVal);
            } else {
                ListNode next = new ListNode(actVal);
                next.next = head.next;
                head.next = next;
            }
        }

        if (jinwei != 0) {
            ListNode next = new ListNode(jinwei);
            next.next = head.next;
            head.next = next;
        }

        return head.next;
    }
}
