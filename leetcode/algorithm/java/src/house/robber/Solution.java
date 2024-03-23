package house.robber;

class Solution {

	private int rob(int[] nums, Integer[] maxValues, int index) {
		if (index < 0) {
			return 0;
		}

		if (maxValues[index] != null) {
			return maxValues[index];
		}

		int maxValuesAtIndexMinus2 = rob(nums, maxValues, index - 2);
		int maxValuesAtIndexMinus1 = rob(nums, maxValues, index - 1);

		maxValues[index] =
			maxValuesAtIndexMinus2 + nums[index] > maxValuesAtIndexMinus1 ?
			maxValuesAtIndexMinus2 + nums[index] :
			maxValuesAtIndexMinus1;

		return maxValues[index];
	}

	public int rob(int[] nums) {
		if (nums.length < 2) {
			return nums[0];
		}

		int maxValuesAtIndexMinus2 = nums[0];
		int maxValuesAtIndexMinus1 = nums[1] > nums[0] ? nums[1] : nums[0];

		int maxValuesAtIndex = maxValuesAtIndexMinus1;

		for (int i = 2; i < nums.length; ++i) {
			maxValuesAtIndex =
				maxValuesAtIndexMinus2 + nums[i] > maxValuesAtIndexMinus1 ?
				maxValuesAtIndexMinus2 + nums[i] :
				maxValuesAtIndexMinus1;

			maxValuesAtIndexMinus2 = maxValuesAtIndexMinus1;
			maxValuesAtIndexMinus1 = maxValuesAtIndex;
		}

		return maxValuesAtIndex;
	}
}