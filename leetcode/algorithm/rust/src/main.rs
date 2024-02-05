mod two_sum;

use two_sum::Solution;

fn main() {
	println!("Hello, world!");

	let v1:Vec<i32> = Solution::two_sum(vec![2,7,11,15], 22);

	println!("The indexes are: {:?}", v1);
}