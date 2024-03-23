package house.robber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.singlely.linked.list.node.ListNode;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();

		assertEquals(1, sol.rob(new int[]{1, 2, 3, 1}));
	}
}
