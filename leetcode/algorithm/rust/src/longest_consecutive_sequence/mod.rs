use std::collections::HashSet;

pub struct Solution {
}

impl Solution {

	fn wing_size(curr_num: i32, nums_in_hash_set_ref: &HashSet<i32>, visited_ref: &mut HashSet<i32>, left_wing: bool) -> i32 {

		if !nums_in_hash_set_ref.contains(&curr_num) {
			return 0;
		}

		visited_ref.insert(curr_num);

		if left_wing {
			Self::wing_size(curr_num - 1, nums_in_hash_set_ref, visited_ref, left_wing) + 1
		}
		else {
			Self::wing_size(curr_num + 1, nums_in_hash_set_ref, visited_ref, left_wing) + 1
		}
	}

	pub fn longest_consecutive(nums: Vec<i32>) -> i32 {

		let nums_in_hash_set: HashSet<i32> = nums.iter().copied().collect();

		let mut visited: HashSet<i32> = HashSet::with_capacity(nums.len());

		let mut longest_lenth = 0;

		let mut current_length = 0;

		for num in nums {
			if visited.contains(&num) {
				continue;
			}

			current_length += Self::wing_size(num, &nums_in_hash_set, &mut visited, true);
			current_length += Self::wing_size(num, &nums_in_hash_set, &mut visited, false);

			current_length -= 1;

			if current_length > longest_lenth {
				longest_lenth = current_length;
			}
			current_length = 0;
		}

		longest_lenth
	}
}

#[cfg(test)]
mod tests {
use super::Solution;


	#[test]
	fn test() {
		assert_eq!(4, Solution::longest_consecutive(vec![100,4,200,1,3,2]));
		assert_eq!(9, Solution::longest_consecutive(vec![0,3,7,2,5,8,4,6,0,1]));
	}
}