package solution;

import model.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> quque = new LinkedList<>();

        ListNode current = head;
        while (current != null) {
            stack.push(current.val);
            quque.offer(current.val);
            current = current.next;
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(quque.poll())) {
                return false;
            }
        }

        return true;
    }
}
