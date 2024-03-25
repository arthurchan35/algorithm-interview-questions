package longest.palindromic.substring;

class Solution {

	int[] maxSpan = new int[2];

	private void spanFromCenter(String s, int center, boolean odd) {

		int l = center;
		int r = odd ? center + 1 : center + 2;

		int maxLeft = l;
		int maxRight = odd ? center + 1 : center;


		while (true) {
			if (l < 0) {
				break;
			}

			char leftChar = s.charAt(l);

			if (r - 1 >= s.length()) {
				break;
			}

			char rightChar = s.charAt(r - 1);

			if (leftChar != rightChar) {
				break;
			}

			maxLeft = l;
			maxRight = r;

			l -= 1;
			r += 1;

		}

		if (maxSpan[1] - maxSpan[0] < maxRight - maxLeft) {
			maxSpan[1] = maxRight;
			maxSpan[0] = maxLeft;
		}
	}

	public String longestPalindrome(String s) {

		if (s.length() < 1) {
			return "";
		}

		for (int i = 0; i < s.length(); ++i) {
			spanFromCenter(s, i, true);
			spanFromCenter(s, i, false);
		}

		return s.substring(maxSpan[0], maxSpan[1]);
	}
}