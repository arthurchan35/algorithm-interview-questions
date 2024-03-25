package longest.palindromic.substring;

class Solution {

	// if string from index 1 to index 10(exclusive) is a palindrom
	// then isPalindromeIndex[1][10] is true
	Boolean[][] isPalindromeIndex;

	private boolean isPalindrome(String s, int i, int j) {

		if (isPalindromeIndex[i][j] != null) {
			return isPalindromeIndex[i][j];
		}

		if (i >= j - 1) {
			isPalindromeIndex[i][j] = true;
			return true;
		}

		if (s.charAt(i) == s.charAt(j - 1)) {
			boolean isSubPalindrome = isPalindrome(s, i + 1, j - 1);

			if (isSubPalindrome == false) {
				isPalindromeIndex[i][j] = false;
				return false;
			}

			isPalindromeIndex[i][j] = true;
			return true;
		}
		else {
			isPalindromeIndex[i][j] = false;
			return false;
		}
	}
	private int[] longestPalindrome(String s, int i, int j) {
		if (isPalindrome(s, i, j)) {
			return new int[]{i, j};
		}

		int[] left = longestPalindrome(s, i, j - 1);
		int[] right = longestPalindrome(s, i + 1, j);

		if (left[1] - left[0] > right[1] - right[0]) {
			return left;
		}
		else {
			return right;
		}
	}

	public String longestPalindrome(String s) {
		isPalindromeIndex = new Boolean[s.length() + 1][s.length() + 1];

		int[] longestRange = longestPalindrome(s, 0, s.length());

		if (longestRange[1] - longestRange[0] > 0) {
			return s.substring(longestRange[0], longestRange[1]);
		}

		return "";
	}
}