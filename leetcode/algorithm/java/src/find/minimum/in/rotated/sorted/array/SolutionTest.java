package find.minimum.in.rotated.sorted.array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();

		assertEquals(1, sol.findMin(new int[]{1,2}));
		assertEquals(1, sol.findMin(new int[]{3,4,5,1,2}));
		assertEquals(0, sol.findMin(new int[]{4,5,6,7,0,1,2}));
		assertEquals(11, sol.findMin(new int[]{11,13,15,17}));
	}
}
