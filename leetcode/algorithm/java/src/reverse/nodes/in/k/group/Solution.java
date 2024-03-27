package reverse.nodes.in.k.group;

import util.singlely.linked.list.node.ListNode;

class Solution {
 
	public ListNode reverseNodeInGroup(ListNode prev, ListNode current, ListNode nextHead) {

		ListNode next = current.next;

		current.next = prev;

		if (next == nextHead) {
			return current;
		}

		return reverseNodeInGroup(current, next, nextHead);
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k < 2) {
			return head;
		}

		ListNode prevHead = null;
		ListNode currHead = head;

		ListNode current = head;

		ListNode newHead = head;

		int count = 0;

		while (current != null) {
			count += 1;

			if (count == k + 1) {
				// we have found next head
				ListNode newCurrentHead = reverseNodeInGroup(null, currHead, current);

				ListNode test = newCurrentHead;

				while (test != null) {
					test = test.next;
				}
				if (prevHead != null) {
					prevHead.next = newCurrentHead;
				}

				if (newHead == head) {
					newHead = newCurrentHead;
				}

				prevHead = currHead;
				currHead = current;

				count = 1;
			}

			current = current.next;
		}

		if (count == k) {
			ListNode newCurrentHead = reverseNodeInGroup(null, currHead, null);

			if (prevHead != null) {
				prevHead.next = newCurrentHead;
			}

			if (newHead == head) {
				newHead = newCurrentHead;
			}
		}
		else {
			if (prevHead != null) {
				prevHead.next = currHead;
			}
		}

		return newHead;
	}
}