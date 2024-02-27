mod add_two_numbers;
mod contains_duplicate;
mod group_anagrams;
mod is_anagram;
mod product_of_array_except_self;
mod remove_duplicates;
mod top_k_frequent_elements;
mod two_sum;

fn main() {
	add_two_numbers::Solution::add_two_numbers(None, None);

	contains_duplicate::Solution::contains_duplicate(vec![1]);

	is_anagram::Solution::is_anagram(String::new(), String::new());

	group_anagrams::Solution::group_anagrams(vec![]);

	product_of_array_except_self::Solution::product_except_self(vec![]);

	remove_duplicates::Solution::remove_duplicates(&mut vec![1]);

	top_k_frequent_elements::Solution::top_k_frequent(vec![], 2);

	two_sum::Solution::two_sum(vec![2,7,11,15], 22);
}