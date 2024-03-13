pub struct Solution {
}

/*
	0  1  2  3  4  5  6  7  8  9
	7  6  4  3  1  2  3 
	7  8  9  6  7  2  3
*/
impl Solution {
	pub fn max_profit(prices: Vec<i32>) -> i32 {
		if prices.len() < 2 {
			return 0;
		}

		let mut i = 0;
		let mut j = i + 1;

		let mut max = 0;

		while i < j && j < prices.len() {
			if prices[i] >= prices[j] {
				let j_temp = j;
				i = j_temp;
				j = i + 1;
				continue;
			}

			if prices[j] - prices[i] > max {
				max = prices[j] - prices[i];
			}

			j += 1;
		}

		max
	}
}

#[cfg(test)]
mod tests {
	use super::Solution;

	#[test]
	fn test() {

		assert_eq!(5, Solution::max_profit(vec![7,1,5,3,6,4]));
		assert_eq!(0, Solution::max_profit(vec![7,6,4,3,1]));
		assert_eq!(2, Solution::max_profit(vec![7,6,4,3,1,2,3]));
		assert_eq!(2, Solution::max_profit(vec![7,8,9,6,7,2,3]));
	}
}