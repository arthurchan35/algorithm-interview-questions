package reverse.linked.list;

/*
 *  1 -> 2 -> 3 -> 4 -> 5 -> null
 * 
 * 			     p    c  n
 *  null <- 1 <- 2    3  4 -> 5 -> null
 *  null <- 1 <- 2 <- 3  4 -> 5 -> null
 * 
 */
class Solution {

	private ListNode reverseRecursively(ListNode curr, ListNode prev) {
		ListNode next = curr.next;

		curr.next = prev;

		if (next == null)  {
			return curr;
		}

		return reverseRecursively(next, curr);
	}

	private ListNode reverseIteratively(ListNode curr) {

		ListNode prev = null;

		while (curr.next != null) {
			ListNode next = curr.next;

			curr.next = prev;

			prev = curr;

			curr = next;
		}

		curr.next = prev;

		return curr;
	}

	public ListNode reverseList(ListNode head) {

		if (head == null) {
			return head;
		}

		//return reverseRecursively(head, null);

		return reverseIteratively(head);
	}
}