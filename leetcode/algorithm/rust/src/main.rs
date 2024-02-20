mod two_sum;
mod add_two_numbers;
mod remove_duplicates;

fn main() {
	println!("Hello, world!");

	let v1:Vec<i32> = two_sum::Solution::two_sum(vec![2,7,11,15], 22);
	println!("The indexes are: {:?}", v1);

	let new_list = add_two_numbers::Solution::add_two_numbers(None, None);
	println!("The new list is: {:?}", new_list);

}