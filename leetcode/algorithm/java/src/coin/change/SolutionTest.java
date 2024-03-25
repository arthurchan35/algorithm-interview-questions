package coin.change;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();

		assertEquals(2, sol.coinChange(new int[]{1,5,7}, 10));
	}
}
