pub struct Solution {
}

impl Solution {

	pub fn three_sum(nums: Vec<i32>) -> Vec<Vec<i32>> {

		if nums.len() < 3 {
			return vec![];
		}

		let mut sorted_nums = nums;
		sorted_nums.sort();

		let mut results:Vec<Vec<i32>> = Vec::with_capacity(sorted_nums.len());

		for i in 0.. sorted_nums.len() - 2 {

			let ith = sorted_nums[i];

			// i should only use next different number

			if i > 0 && ith == sorted_nums[i - 1] {
				continue;
			}

			let mut j = i + 1;
			let mut k = sorted_nums.len() - 1;

			while j < k {

				// j should only use next different number
				// e.g. -3, 0, 0, 1, 2, 3, 3

				if j > i + 1 && sorted_nums[j] == sorted_nums[j - 1] {
					j += 1;
					continue;
				}

				// k should only use next different number
				// e.g. -3, 0, 0, 1, 2, 3, 3

				if k < sorted_nums.len() - 1 && sorted_nums[k] == sorted_nums[k + 1] {
					k -= 1;
					continue;
				}

				let sum = ith + sorted_nums[j] + sorted_nums[k];

				if sum > 0 {
					k -= 1;
					continue;
				}

				if sum < 0 {
					j += 1;
					continue;
				}

				results.push(vec![ith, sorted_nums[j], sorted_nums[k]]);
				j += 1;
				k -= 1;
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

		let results = Solution::three_sum(vec![-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0]);

		assert_eq!(6, results.len());
		for vec in results {
			assert!(vec.len() == 3);
			assert_eq!(0, vec.iter().sum());
		}

	}
}