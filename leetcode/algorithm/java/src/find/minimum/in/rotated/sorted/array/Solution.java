package find.minimum.in.rotated.sorted.array;

/* 0 1 2 3 4 5
 * 
 * 3 4 5 6 1 2
 * 6 1 2 3 4 5
 * 1 2 3 4 5 6
 * 2 3 4 5 6 1
 */
class Solution {

	private int findMin(int[] nums, int l, int r) {

		int m = (l + r) / 2;

		// 1
		if (l == r) {
			return nums[m];
		}

		if (l == m) {
			if (nums[m] <= nums[m + 1]) {
				return nums[m];
			}
		}
		else if (m == r) {
			if (nums[m] <= nums[m - 1]) {
				return nums[m];
			}
		}
		else if (nums[m] < nums[m - 1] && nums[m] < nums[m + 1]) {
			return nums[m];
		}

		if (nums[m] < nums[r]) {
			return findMin(nums, l, m - 1);
		}
		else {
			return findMin(nums, m + 1, r);
		}
	}

	public int findMin(int[] nums) {
		return findMin(nums, 0, nums.length - 1);
	}
}