package solution;

import model.ListNode61;

public class LeetCode83 {
	public ListNode61 deleteDuplicates(ListNode61 head) {
		ListNode61 parent = head;
		ListNode61 current = head;
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
