package solution;

import model.ListNode;

public class LeetCode61 {
	public ListNode rotateRight(ListNode head, int k) {
		int length = 0;

		ListNode current = head;
		ListNode lastParent = null;
		while (current != null) {
			length++;
			lastParent = current;
			current = current.next;
		}

		if (length != 0 && length != 1) {
			int realK = k % length;
			if (realK != 0) {
				int realKBack = length - realK;
				ListNode parent = null;
				ListNode newHead = head;
				while (realKBack > 0) {
					parent = newHead;
					newHead = newHead.next;
					realKBack--;
				}
				lastParent.next = head;
				parent.next = null;
				return newHead;
			}
		}

		return head;
	}
}
