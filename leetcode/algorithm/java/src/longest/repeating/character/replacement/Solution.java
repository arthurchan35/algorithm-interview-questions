package longest.repeating.character.replacement;

class Solution {

	private int majorityCharCount(int[] charCount) {
		int maxCount = 0;

		for (int i = 0; i < charCount.length; ++i) {
			if (charCount[i] > maxCount) {
				maxCount = charCount[i];
			}
		}

		return maxCount;
	}

	//abab
	public int characterReplacement(String s, int k) {

		int l = 0;
		int r = 0;

		int[] charCount = new int[26];

		int maxWindowSize = 0;

		while (r < s.length()) {
			charCount[s.charAt(r) - 'A'] += 1;

			int majorityCharCount = majorityCharCount(charCount);

			// r + 1 - l = window size

			while (r + 1 - l - majorityCharCount > k) {
				charCount[s.charAt(l) - 'A'] -= 1;
				l += 1;
				majorityCharCount = majorityCharCount(charCount);
			}

			if (r + 1 - l > maxWindowSize) {
				maxWindowSize = r + 1 - l;
			}

			r += 1;
		}

		return maxWindowSize;
	}
}