package longest.repeating.character.replacement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();

		assertEquals(4, sol.characterReplacement("ABAB", 2));
		assertEquals(4, sol.characterReplacement("AACBABBA", 1));
	}
}
