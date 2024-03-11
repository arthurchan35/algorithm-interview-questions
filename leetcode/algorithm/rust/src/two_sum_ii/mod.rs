pub struct Solution {
}

impl Solution {
	pub fn two_sum(sorted_nums: Vec<i32>, target: i32) -> Vec<i32> {

		let mut i = 0;
		let mut j = sorted_nums.len() - 1;

		while i < j {
			let sum = sorted_nums[i] + sorted_nums[j];

			if sum == target {
				return vec![i as i32 + 1, j as i32 + 1];
			}

			if sum < target {
				i += 1
			}
			else {
				j -= 1
			}
		}
		vec![]
	}
}

#[cfg(test)]
mod tests {
	use super::Solution;

	#[test]
	fn test() {
		let vec1 = vec![2,7,11,15];
		let found_indexes_01:Vec<i32> = Solution::two_sum(vec1.clone(), 9);
		assert_eq!(vec1[found_indexes_01[0] as usize - 1] + vec1[found_indexes_01[1] as usize - 1], 9);
		assert_ne!(vec1[found_indexes_01[0] as usize - 1] + vec1[found_indexes_01[1] as usize - 1], 1);
	}
}