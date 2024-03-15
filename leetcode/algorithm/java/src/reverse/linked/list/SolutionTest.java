package reverse.linked.list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.singlely.linked.list.node.ListNode;

public class SolutionTest {

	private ListNode buildList() {
		ListNode head = new ListNode(0);

		ListNode curr = head;

		for (int i = 1; i < 10; ++i) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}

		return head;
	}

	@Test
	public void test() {
		Solution sol = new Solution();

		ListNode head1 = buildList();

		ListNode newHead1 = sol.reverseList(head1);

		for (int i = 9; i > -1; --i) {
			assertEquals(i, newHead1.val);

			newHead1 = newHead1.next;
		}

		assertEquals(null, newHead1);
	}
}
