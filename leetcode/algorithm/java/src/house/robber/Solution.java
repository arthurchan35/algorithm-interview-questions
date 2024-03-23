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

		Integer[] maxValues = new Integer[nums.length];

		maxValues[0] = nums[0];

		rob(nums, maxValues, nums.length - 1);

		return maxValues[nums.length - 1];
	}
}