pub struct Solution {
}

impl Solution {
	pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
		if nums.is_empty() {
			return 0;
		}

		let mut last_index_to_modify = 1;

		let mut last_val:i32 = nums[0];

		for index in 0..nums.len() {
			if nums[index] != last_val {
				nums[last_index_to_modify] = nums[index];
				last_val = nums[index];
				last_index_to_modify += 1;
			}
		}

		last_index_to_modify as i32
	}
}


#[cfg(test)]
mod tests {
use super::{Solution};


	#[test]
	fn test_remove_duplicates() {
		let mut test_nums_1 = vec![1, 2, 2, 3, 3, 3, 4, 4, 4, 4];

		let result = Solution::remove_duplicates(&mut test_nums_1);

		println!("new list = {:?}, len = {}", test_nums_1, result)
	}
}