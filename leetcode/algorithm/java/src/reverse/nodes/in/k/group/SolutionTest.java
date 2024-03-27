package reverse.nodes.in.k.group;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.singlely.linked.list.node.ListNode;

public class SolutionTest {

	private ListNode buildList() {
		ListNode head = new ListNode(1);

		ListNode curr = head;

		for (int i = 2; i < 11; ++i) {
			curr.next = new ListNode(i);
			curr = curr.next;
		}

		return head;
	}

	@Test
	public void test() {
		Solution sol = new Solution();

		ListNode head1 = buildList();

/*		ListNode test = sol.reverseNodeInGroup(null, head1, null);

		while (test != null) {
			System.out.print(test.val + ", ");
			test = test.next;
		}*/
		ListNode newHead1 = sol.reverseKGroup(head1, 5);

		while (newHead1 != null) {
			System.out.print(newHead1.val + ", ");
			newHead1 = newHead1.next;
		}
	}
}