package valid.parentheses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();

		assertEquals(false, sol.isValid("([)]"));
		assertEquals(true, sol.isValid("()[]{}"));
		assertEquals(false, sol.isValid("(]"));
	}
}
