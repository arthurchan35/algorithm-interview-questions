package house.robber;

class Solution {

	// nums need to be size of 2 at least
	private int[] rob(int[] nums, int index) {
		if (index == 1) {
			return new int[] {nums[0], nums[0] > nums[1] ? nums[0] : nums[1]};
		}


		int[] maxValues = rob(nums, index - 1);

		int maxValueAtIndex =
			maxValues[0] + nums[index] >  maxValues[1] ?
			maxValues[0] + nums[index] : maxValues[1];

		maxValues[0] = maxValues[1];
		maxValues[1] = maxValueAtIndex;

		return maxValues;
	}

	public int rob(int[] nums) {
		if (nums.length < 2) {
			return nums[0];
		}

		int[] maxValues = rob(nums, nums.length - 1);

		return maxValues[1];
	}
}