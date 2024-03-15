package reorder.list;

import util.singlely.linked.list.node.ListNode;

/*
 * odd
 * 0 1 2 3 4
 * 0 1
 * 2 3 4 -> 4 3 2
 * 0 4 1 3 2
 * 
 * even
 * 0 1 2 3 4 5
 * 0 1 2
 * 3 4 5 - > 5 4 3
 * 0 5 1 4 2 3
 */

 class Solution {
	private ListNode reverse(ListNode curr, ListNode prev) {
		ListNode next = curr.next;

		curr.next = prev;

		if (next == null) {
			return curr;
		}

		return reverse(next, curr);
	}

	/*
	 * 0 1 2
	 * 5 4 3
	 * 
	 * 0 1
	 * 4 3 2
	 */
	private void mergeTwoLists(ListNode h1, ListNode h2) {

		ListNode dummyHead = new ListNode();
		ListNode current = dummyHead;

		while (true) {
			if (h1 == null) {
				current.next = h2;
				break;
			}
			if (h2 == null) {
				current.next = h1;
				break;
			}

			ListNode h1Next = h1.next;
			ListNode h2Next = h2.next;

			current.next = h1;
			current = current.next;
			current.next = h2;
			current = current.next;

			h1 = h1Next;
			h2 = h2Next;
		}
	}

	public void reorderList(ListNode head) {

		if (head == null || head.next == null) {
			return;
		}

		ListNode slow = head;
		ListNode fast = head;


		while (true) {
			ListNode slowCopy = slow;

			slow = slow.next;
			fast = fast.next.next;

			// even	no. nodes, odd no. nodes
			if (fast == null || fast.next == null) {

				// break up the two halfs, otherwise it would cause a cycle after merging
				slowCopy.next = null;

				break;
			}
		}

		ListNode headOfReverseLatterHalf = reverse(slow, null);

		mergeTwoLists(head, headOfReverseLatterHalf);
	}
}