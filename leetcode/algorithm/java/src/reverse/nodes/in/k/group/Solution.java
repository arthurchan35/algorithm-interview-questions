package reverse.nodes.in.k.group;

import java.util.ArrayDeque;
import java.util.Deque;

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

		Deque<ListNode> headNodes = new ArrayDeque<>();

		ListNode current = head;

		int count = k;
		while (current != null) {
			if (count == k) {
				headNodes.offerLast(current);
				count = 0;
			}

			current = current.next;
			count += 1;
		}


		ListNode prevHead = null;
		ListNode newHead = null;

		while (!headNodes.isEmpty()) {
			ListNode currentHead = headNodes.pollFirst();

			// at the last group
			if (headNodes.isEmpty()) {

				// last group is in-complete
				if (count != k) {
					if (prevHead != null) {
						prevHead.next = currentHead;
					}
					else {
						newHead = currentHead;
					}
					break;
				}
			}

			ListNode nextHead = headNodes.peekFirst();

			ListNode newCurrentHead = reverseNodeInGroup(null, currentHead, nextHead);

			if (prevHead != null) {
				prevHead.next = newCurrentHead;
			}
			else {
				newHead = newCurrentHead;
			}

			prevHead = currentHead;
		}

		return newHead;
	}
}