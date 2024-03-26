package coin.change;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();

		assertEquals(2, sol.coinChange(new int[]{1,5,7}, 10));
		assertEquals(4, sol.coinChange(new int[]{2,5,10,1}, 27));
		assertEquals(24, sol.coinChange(new int[]{411,412,413,414,415,416,417,418,419,420,421,422}, 9864));
	}
}