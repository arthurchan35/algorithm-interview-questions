use std::collections::HashSet;

pub struct Solution {
}

impl Solution {
	pub fn three_sum(nums: Vec<i32>) -> Vec<Vec<i32>> {

		if nums.len() < 3 {
			return vec![];
		}

		let mut sorted_nums = nums.clone();
		sorted_nums.sort();

		let num_set:HashSet<i32> = nums.into_iter().collect();

		let mut results:Vec<Vec<i32>> = Vec::with_capacity(sorted_nums.len());

		for i in 0.. sorted_nums.len() {

			let ith = sorted_nums[i];

			// i should only use next different number

			if i > 0 && ith == sorted_nums[i - 1] {
				continue;
			}

			for j in i + 1.. sorted_nums.len() {

				let jth = sorted_nums[j];

				// j should only use next different number

				if j > i + 1 && jth == sorted_nums[j - 1] {
					continue;
				}

				if let Some(last_num_ref) = num_set.get(&(0 - ith - jth)) {

					// if the 3rd number found is smaller than j,
					// then the 3rd number is definitely used as i before

					if *last_num_ref < jth {
						continue;
					}
					if *last_num_ref > jth {
						results.push(vec![ith, jth, *last_num_ref]);
						continue;
					}

					// *last_num_ref == jth, e.g. input:[-1, 0, 0, 0, 1]
					// one result will be: 0, 0, 0

					if j < sorted_nums.len() - 1 && jth == sorted_nums[j + 1] {
						results.push(vec![ith, jth, *last_num_ref]);
					}

					continue;

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

		/*
						0,  1,  2,  3,  4,  5
		before sorted: -1,  0,  1,  2, -1, -4
		after sorted:  -4, -1, -1,  0,  1,  2
		 */
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

		let results = Solution::three_sum(vec![-1,0,1,2,-1,-4,-2,-3,3,0,4]);

		assert_eq!(9, results.len());
		for vec in results {
			assert!(vec.len() == 3);
			assert_eq!(0, vec.iter().sum());
		}

	}
}