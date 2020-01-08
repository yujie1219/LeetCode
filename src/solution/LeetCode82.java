package solution;

import model.ListNode;

public class LeetCode82 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		if (head.next.next == null) {
			if (head.val == head.next.val) {
				return null;
			} else {
				return head;
			}
		}

		ListNode newHead = null;
		ListNode parent = null;
		ListNode current = head;
		ListNode child = head.next;
		int times = 1;
		while (child != null) {
			if (current.val != child.val) {
				if (times > 1) {
					if (parent != null) {
						parent.next = child;
					}
					times = 1;
				} else {
					if (newHead == null) {
						newHead = current;
					}
					parent = current;
				}
			} else {
				times++;
			}
			current = child;
			child = child.next;
		}

		if (times == 1 && newHead == null) {
			newHead = current;
		}
		if (times > 1 && parent != null) {
			parent.next = null;
		}
		return newHead;
	}
}
