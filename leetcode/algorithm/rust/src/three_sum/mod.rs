use std::collections::{HashMap, HashSet};

pub struct Solution {
}

impl Solution {
	pub fn three_sum(nums: Vec<i32>) -> Vec<Vec<i32>> {

		// lang quick tip for searching: visited_ij.entry(i).or_insert_with(HashSet::new);

		let mut nums_counts:HashMap<i32, usize> = HashMap::with_capacity(nums.len());

		for num in &nums {
			if let Some(count_ref) = nums_counts.get_mut(num) {
				*count_ref += 1;
			}
			else {
				nums_counts.insert(*num, 1);
			}
		}

		let mut results:Vec<Vec<i32>> = Vec::with_capacity(nums.len());

		for i in 0.. nums.len() {

			if let Some(count_ref) = nums_counts.get_mut(&nums[i]) {

				// for each result in results, make sure nums[i] is not used more than once
				*count_ref -= 1;

				for j in i + 1.. nums.len() {

					if let Some(count_ref) = nums_counts.get_mut(&nums[j]) {
						// for each result in results, make sure nums[j] is not used more than once
						*count_ref -= 1;
					}

					if let Some(count_ref) = nums_counts.get(&(0 - nums[i] - nums[j])) {
						if *count_ref > 0 {
							results.push(vec![nums[i], nums[j], 0 - nums[i] - nums[j]]);
						}
					}

					if let Some(count_ref) = nums_counts.get_mut(&nums[j]) {
						*count_ref += 1;
					}
				}
	
				if let Some(count_ref) = nums_counts.get_mut(&nums[i]) {
					*count_ref += 1;
				}
			}
		}

		results
	}
}

#[cfg(test)]
mod tests {
	use super::Solution;

	#[test]
	fn test() {

		let results = Solution::three_sum(vec![-1,0,1,2,-1,-4]);

		assert_eq!(2, results.len());

		for vec in results {
			assert!(vec.len() == 3);
			assert_eq!(0, vec.iter().sum());
		}

		let results = Solution::three_sum(vec![0, 0, 0, 0, 0, 0]);

		assert_eq!(1, results.len());

		for vec in results {
			assert!(vec.len() == 3);
			assert_eq!(0, vec.iter().sum());
		}
	}
}