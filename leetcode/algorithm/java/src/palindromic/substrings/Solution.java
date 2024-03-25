package palindromic.substrings;

class Solution {

	private int countFromCenter(String s, int center, boolean odd) {

		int l = center;
		int r = odd ? center + 1 : center + 2;

		int count = 0;

		while (true) {
			if (l < 0) {
				break;
			}
			char left = s.charAt(l);

			if (r - 1 >= s.length()) {
				break;
			}
			char right = s.charAt(r - 1);

			if (left != right) {
				break;
			}

			count += 1;
			l -= 1;
			r += 1;
		}

		return count;
	}

	public int countSubstrings(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); ++i) {
			count += countFromCenter(s, i, false);
			count += countFromCenter(s, i, true);
		}

		return count;
	}
}