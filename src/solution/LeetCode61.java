package solution;

import model.ListNode61;

public class LeetCode61 {
	public ListNode61 rotateRight(ListNode61 head, int k) {
		int length = 0;

		ListNode61 current = head;
		ListNode61 lastParent = null;
		while (current != null) {
			length++;
			lastParent = current;
			current = current.next;
		}

		if (length != 0 && length != 1) {
			int realK = k % length;
			if (realK != 0) {
				int realKBack = length - realK;
				ListNode61 parent = null;
				ListNode61 newHead = head;
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
