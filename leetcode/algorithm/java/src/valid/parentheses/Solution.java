package valid.parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>(s.length());

		for (int i = 0; i < s.length(); ++i) {

			char c = s.charAt(i);

			if (c == ')') {
				if (stack.isEmpty() || stack.pollLast() != '(') {
					return false;
				}

				continue;
			}
			if (c == '}') {
				if (stack.isEmpty() || stack.pollLast() != '{') {
					return false;
				}

				continue;
			}
			if (c == ']') {
				if (stack.isEmpty() || stack.pollLast() != '[') {
					return false;
				}

				continue;
			}

			stack.offerLast(s.charAt(i));
		}

		return stack.isEmpty();
	}
}