package find.minimum.in.rotated.sorted.array;

/* 0 1 2 3 4 5
 * 
 * 3 4 5 6 1 2
 * 6 1 2 3 4 5
 * 1 2 3 4 5 6
 * 2 3 4 5 6 1
 */
class Solution {

	private int findMin(int[] nums, int l, int m, int r) {

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
			int length = m - l;

			int mid = length / 2 + l;
	
			if ((length & 1) == 0) {
				mid -= 1;
			}

			return findMin(nums, l, mid, m - 1);
		}
		else {
			int length = r - m;

			int mid = length / 2 + m + 1;
	
			if ((length & 1) == 0) {
				mid -= 1;
			}

			return findMin(nums, m + 1, mid, r);
		}
	}

	public int findMin(int[] nums) {
		int mid = nums.length / 2;
		if ((nums.length & 1) == 0) {
			mid -= 1;
		}

		return findMin(nums, 0, mid, nums.length - 1);
	}
}