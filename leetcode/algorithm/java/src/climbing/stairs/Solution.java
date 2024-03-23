package climbing.stairs;

class Solution {

	public int climbStairs(int n) {
		if (n < 3) {
			return n;
		}

		int secondLastStep = 1;
		int firstLastStep = 2;
		int current = 0;

		for (int i = 3; i < n + 1; ++i) {
			current = secondLastStep + firstLastStep;
			secondLastStep = firstLastStep;
			firstLastStep = current;
		}

		return current;
	}
}