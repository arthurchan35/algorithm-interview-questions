package house.robber.ii;

class Solution {


	private int robMax(int[] nums, int s, int e) {

		if (s >= e) {
			return 0;
		}

		if (s + 1 == e) {
			return nums[s];
		}

		int maxValAt2StepBefore = nums[s];
		int maxValAt1StepBefore = nums[s + 1] > nums[s] ? nums[s + 1] : nums[s];

		int maxValAtCurr = maxValAt1StepBefore;

		for (int i = s + 2; i < e; ++i) {
			maxValAtCurr =
				maxValAt2StepBefore + nums[i] > maxValAt1StepBefore ?
				maxValAt2StepBefore + nums[i] :
				maxValAt1StepBefore;

			maxValAt2StepBefore = maxValAt1StepBefore;
			maxValAt1StepBefore = maxValAtCurr;
		}

		return maxValAtCurr;
	}

	public int rob(int[] nums) {
		if (nums.length < 2) {
			return nums[0];
		}

		int max0ToLengthMinus2 = robMax(nums, 0, nums.length - 1);
		int max1ToLengthMinus1 = robMax(nums, 1, nums.length );

		return max0ToLengthMinus2 > max1ToLengthMinus1 ? max0ToLengthMinus2 : max1ToLengthMinus1;
	}
}