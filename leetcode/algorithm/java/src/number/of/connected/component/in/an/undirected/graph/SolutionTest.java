package number.of.connected.component.in.an.undirected.graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.singlely.linked.list.node.ListNode;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();

		assertEquals(1, sol.countComponents(3, new int[][]{{0,1},{0,2},{1,2}}));
	}
}
