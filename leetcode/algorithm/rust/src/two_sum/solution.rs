use super::Solution;
use std::collections::HashMap;

impl Solution {
	pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {

		let mut num_and_index_map:HashMap<i32, usize> = HashMap::new();

		for enumerator in nums.iter().enumerate() {
			println!("index: {}, value pointer: {}, value: {}", enumerator.0, enumerator.1, *enumerator.1);

			let found_index = num_and_index_map.get(&(target - *enumerator.1));

			if found_index.is_some() {
				println!("found and return");
				return vec![enumerator.0.try_into().unwrap(), (*found_index.unwrap()).try_into().unwrap()];
			}

			num_and_index_map.insert(*enumerator.1, enumerator.0);
		}

		vec![]
	}
}