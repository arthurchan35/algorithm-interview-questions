package house.robber;

class Solution {

	private void rob(int[] nums, int[] maxValues, int index) {
		if (index >= nums.length) {
			return;
		}

		int newCurrentMaxValue = maxValues[0] + nums[index] > maxValues[1] ?
			maxValues[0] + nums[index] :
			maxValues[1];

		maxValues[0] = maxValues[1];
		maxValues[1] = newCurrentMaxValue;
		maxValues[2] = maxValues[1];

		rob(nums, maxValues, index + 1);
	}

	public int rob(int[] nums) {
		if (nums.length < 2) {
			return nums[0];
		}

		int[] maxValues = new int[3];

		maxValues[0] = nums[0];
		maxValues[1] = nums[1] > nums[0] ? nums[1] : nums[0];

		maxValues[2] = maxValues[1];

		rob(nums, maxValues, 2);

		return maxValues[2];
	}
}