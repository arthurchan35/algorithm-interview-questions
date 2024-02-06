use std::collections::HashMap;

pub struct Solution {
}

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

#[cfg(test)]
mod tests {
	use super::Solution;

	#[test]
	fn test_two_sum() {
		let vec1 = vec![15,7,0, -1, 10, 11, 2];
		let found_indexes_01:Vec<i32> = Solution::two_sum(vec1.clone(), 9);
		assert_eq!(vec1[found_indexes_01[0] as usize] + vec1[found_indexes_01[1] as usize], 9);
		assert_ne!(vec1[found_indexes_01[0] as usize] + vec1[found_indexes_01[1] as usize], 1);
	}
}