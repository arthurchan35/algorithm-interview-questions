package search.in.rotated.sorted.array;

/* 0 1 2 3 4 5 6
 * 
 * 3 4 5 6 7 1 2
 * 6 7 1 2 3 4 5
 * 7 1 2 3 4 5 6
 * 2 3 4 5 6 7 1
 * 5 6 7 1 2 3 4
 */
class Solution {

	private int search(int[] nums, int target, int l, int r) {
		int m = (l + r) / 2;

		if (m < l || m > r || l > r) {
			return -1;
		} 
		if (nums[m] == target) {
			return m;
		}

		boolean rotatedAtLeft = nums[m] < nums[r];

		if (rotatedAtLeft) {
			if (target < nums[m]) {
				return search(nums, target, l, m - 1);
			}

			if (target > nums[r]) {
				return search(nums, target, l, m - 1);
			}
			if (target < nums[r]) {
				return search(nums, target, m + 1, r);
			}
			else {
				return r;
			}
		}
		else {
			if (target > nums[m]) {
				return search(nums, target, m + 1, r);
			}

			if (target < nums[l]) {
				return search(nums, target, m + 1, r);
			}
			if (target > nums[l]) {
				return search(nums, target, l, m - 1);
			}
			else {
				return l;
			}
		}
	}


	public int search(int[] nums, int target) {
		return search(nums, target, 0, nums.length - 1);
	}
}