package search.in.rotated.sorted.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();

		assertEquals(4, sol.search(new int[]{4,5,6,7,0,1,2}, 0));
		assertEquals(-1, sol.search(new int[]{4,5,6,7,0,1,2}, 3));
		assertEquals(-1, sol.search(new int[]{1}, 0));
	}
}
