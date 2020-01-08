package solution;

import model.ListNode;

public class LeetCode83 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode parent = head;
		ListNode current = head;
		while (current != null) {
			if (parent.val != current.val) {
				parent.next = current;
				parent = current;
			}
			current = current.next;
		}
		if (parent != null)
			parent.next = null;
		return head;
	}
}
