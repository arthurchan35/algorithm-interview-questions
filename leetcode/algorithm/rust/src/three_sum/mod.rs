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

		let mut two_sum:HashSet<i32> = HashSet::with_capacity(nums.len());

		for i in 0.. nums.len() {

			let ith_num = nums[i];

			if let Some(count_ref) = nums_counts.get_mut(&ith_num) {
				*count_ref -= 1;
			}

			for jth_num_ref in nums.iter().skip(i + 1) {

				let jth_num = *jth_num_ref;

				if two_sum.contains(&(ith_num + jth_num)) {
					continue;
				}

				if let Some(count_ref) = nums_counts.get_mut(&jth_num) {
					*count_ref -= 1;
				}

				let last_num = 0 - ith_num - jth_num;

				if let Some(last_num_ref) = nums_counts.get_key_value(&last_num) {
					if *last_num_ref.1 > 0 {
						two_sum.insert(ith_num + jth_num);
						two_sum.insert(ith_num + last_num);
						two_sum.insert(jth_num + last_num);

						results.push(vec![ith_num, jth_num, last_num]);
					}
				}

				if let Some(count_ref) = nums_counts.get_mut(&jth_num) {
					*count_ref += 1;
				}
			}

			if let Some(count_ref) = nums_counts.get_mut(&ith_num) {
				*count_ref += 1;
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