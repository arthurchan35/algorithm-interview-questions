package climbing.stairs;

class Solution {
	private void climbStairs(int n, int[] dp) {
		if (n < 3) {
			dp[n - 1] = n;
		}

		if (dp[n - 1] > 0) {
			return;
		}

		if (dp[n - 3] < 1) {
			climbStairs(n - 2, dp);
		}
		if (dp[n - 2] < 1) {
			climbStairs(n - 1, dp);
		}

		dp[n - 1] = dp[n - 3] + dp[n - 2];
	}

	public int climbStairs(int n) {
		int[] dp = new int[n];

		climbStairs(n, dp);

		return dp[n - 1];
	}
}