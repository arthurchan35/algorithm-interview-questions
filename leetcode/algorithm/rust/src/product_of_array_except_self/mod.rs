pub struct Solution {
}

impl Solution {
	pub fn product_except_self(nums: Vec<i32>) -> Vec<i32> {

		/*
			nums:		[   5,   3,   1,   2,   4]

			prefix_prods =
						--->
						[   1,   5,  15,  15,  30];

			postfix_prods =
												<---
						[  24,   8,   8,   4,   1];
		 */
		let mut prefix_prods:Vec<i32> = vec![1; nums.len()];
		let mut postfix_prods:Vec<i32> = vec![1; nums.len()];

		for index in 0.. nums.len() {
			let rev_index = nums.len() - 1 - index;

			if index > 0 {
				prefix_prods[index] = prefix_prods[index - 1] * nums[index - 1];
			}

			if rev_index < nums.len() - 1 {
				postfix_prods[rev_index] = postfix_prods[rev_index + 1] * nums[rev_index + 1];
			}
		}

		let mut result:Vec<i32> = vec![1; nums.len()];

		for index in 0.. nums.len() {
			result[index] = prefix_prods[index] * postfix_prods[index];
		}

		result
	}
}

#[cfg(test)]
mod tests {
use super::Solution;

	#[test]
	fn test() {
		let expected = vec![24, 40, 120, 60, 30];

		let result = Solution::product_except_self(vec![5, 3, 1, 2, 4]);

		println!("result: {:?}",&result);

		assert_eq!(expected, result);
	}
}