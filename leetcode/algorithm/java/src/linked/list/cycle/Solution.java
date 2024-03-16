package linked.list.cycle;

import util.singlely.linked.list.node.ListNode;

/*
 * consider cases: n = 4, n = 2 or 3, n = 1
 * 
 *          4    3    2    1
 * duumy -> 1 -> 2 -> 3 -> 4 -> null
 */

 public class Solution {
	public boolean hasCycle(ListNode head) {

		if (head == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != null && fast != null && fast.next != null) {
			if (slow == fast) {
				return true;
			}

			slow = slow.next;

			fast = fast.next.next;
		}

		return false;
	}
}