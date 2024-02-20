use std::collections::HashSet;

pub struct Solution {
}

impl Solution {
    pub fn contains_duplicate(nums: Vec<i32>) -> bool {
		let mut nums_map:HashSet<i32> = HashSet::with_capacity(nums.len());

		for num in nums {
			if !nums_map.insert(num) {
				return true;
			}
		}

		false
	}
}

#[cfg(test)]
mod tests {
use super::Solution;


	#[test]
	fn test_contains_duplicate() {
		let test_nums_1 = vec![1, 2, 2, 3, 3, 3, 4, 4, 4, 4];
		assert!(Solution::contains_duplicate(test_nums_1));

		let test_nums_1 = vec![1, 2, 3, 4];
		assert!(!Solution::contains_duplicate(test_nums_1));
	}
}