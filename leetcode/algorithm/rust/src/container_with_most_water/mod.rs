/*
	You are given an integer array height of length n. There are n vertical lines
	drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

	Find two lines that together with the x-axis form a container, such that the
	container contains the most water.

	Return the maximum amount of water a container can store.

	Notice that you may not slant the container.
					 0, 1, 2, 3, 4, 5, 6, 7, 8
	Input: height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
	Output: 49

					 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
	Input: height = [1, 8, 8, 6, 2, 5, 4, 8, 8, 3, 7]
	Output: 63

					 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
	Input: height = [8, 8, 8, 8, 2, 5, 8, 8, 8, 8, 8]
	Output: 80
*/
pub struct Solution {
}

impl Solution {
	pub fn max_area(height: Vec<i32>) -> i32 {
		let mut max_area = 0;

		let mut l:usize = 0;
		let mut r:usize = height.len() - 1;

		let mut left_prev_height = 0;
		let mut right_prev_height = 0;

		while l < r {
			if height[l] <= left_prev_height {
				l += 1;
				continue;
			}

			if height[r] <= right_prev_height {
				r -= 1;
				continue;
			}

			let mut min_height = height[l];

			if min_height > height[r] {
				min_height = height[r];
				right_prev_height = height[r];
			}
			else {
				left_prev_height = height[l];
			}

			let curr_area = (r - l) as i32 * min_height;

			if curr_area > max_area {
				max_area = curr_area;
			}

		}

		max_area
	}
}

#[cfg(test)]
mod tests {
	use super::Solution;

	#[test]
	fn test() {
		assert_eq!(49, Solution::max_area(vec![1, 8, 6, 2, 5, 4, 8, 3, 7]));
		assert_eq!(63, Solution::max_area(vec![1, 8, 8, 6, 2, 5, 4, 8, 8, 3, 7]));
		assert_eq!(80, Solution::max_area(vec![8, 8, 8, 8, 2, 5, 8, 8, 8, 8, 8]));
	}
}