package remove.nth.node.from.end.of.list;

import util.singlely.linked.list.node.ListNode;

/*
 * consider cases: n = 4, n = 2 or 3, n = 1
 * 
 *          4    3    2    1
 * duumy -> 1 -> 2 -> 3 -> 4 -> null
 */

 class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode dummy = new ListNode();
		dummy.next = head;

		ListNode fast = dummy;

		for (int i = 0; i < n; ++i) {
			if (fast == null) {
				return head;
			}

			fast = fast.next;
		}

		if (fast == null) {
			return head;
		}

		ListNode slow = dummy;

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		if (slow.next != null) {
			slow.next = slow.next.next;
		}
		else {
			slow.next = null;
		}

		// if n is the size of nodes,
		// then the first node is to be removed,
		// so we can return head, instead to return dummy.next

		return dummy.next;
	}
}