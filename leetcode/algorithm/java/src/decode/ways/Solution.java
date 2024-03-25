package decode.ways;

class Solution {

	Integer[] memo;

	private int dp(String s, int i) {
		if (i == 0) {
			memo[0] = s.charAt(0) == '0' ? 0 : 1;
		}

		if (memo[i] != null) {
			return memo[i];
		}

		int ways = 0;
		
		if (s.charAt(i) != '0') {
			ways = dp(s, i - 1);

			if (ways == 0) {
				memo[i] = 0;

				return 0;
			}
		}

		if (i - 1 >= 0 && (
		 	(s.charAt(i - 1) == '2'  && s.charAt(i) <= '6' && s.charAt(i) >= '0') ||
			(s.charAt(i - 1) == '1'  && s.charAt(i) <= '9' && s.charAt(i) >= '0'))
		 ) {
			int secondWays = i >= 2 ? dp(s, i - 2) : 1;

			if (secondWays == 0) {
				memo[i] = 0;

				return 0;
			}

			ways += secondWays;
		}

		memo[i] = ways;
		return ways;
	}

	public int numDecodings(String s) {
		memo = new Integer[s.length()];

		return dp(s, s.length() - 1);
	}
}