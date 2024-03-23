package house.robber;

class Solution {

	private int rob(int[] nums, Integer[] maxValues, int index) {
		if (index < 0) {
			return 0;
		}

		if (maxValues[index] != null) {
			return maxValues[index];
		}

		int maxValuesAtIndexMinus3 = rob(nums, maxValues, index - 3);
		int maxValuesAtIndexMinus2 = rob(nums, maxValues, index - 2);
		rob(nums, maxValues, index - 1);

		maxValues[index] =
			maxValuesAtIndexMinus3 > maxValuesAtIndexMinus2 ?
			maxValuesAtIndexMinus3 + nums[index] :
			maxValuesAtIndexMinus2 + nums[index];

		return maxValues[index];
	}

	public int rob(int[] nums) {
		if (nums.length < 2) {
			return nums[0];
		}

		Integer[] maxValues = new Integer[nums.length];

		maxValues[0] = nums[0];
		maxValues[1] = nums[1];

		rob(nums, maxValues, nums.length - 1);

		return maxValues[nums.length - 1] > maxValues[nums.length - 2] ?
			maxValues[nums.length - 1] :
			maxValues[nums.length - 2];
	}
}