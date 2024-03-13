mod add_two_numbers;
mod best_time_to_buy_and_sell_stock;
mod container_with_most_water;
mod contains_duplicate;
mod group_anagrams;
mod is_anagram;
mod longest_consecutive_sequence;
mod longest_substring_without_repeating_characters;
mod product_of_array_except_self;
mod remove_duplicates;
mod top_k_frequent_elements;
mod three_sum;
mod two_sum;
mod two_sum_ii;
mod valid_palindrome;
mod valid_sudoku;

fn main() {
	add_two_numbers::Solution::add_two_numbers(None, None);

	best_time_to_buy_and_sell_stock::Solution::max_profit(vec![]);

	container_with_most_water::Solution::max_area(vec![]);

	contains_duplicate::Solution::contains_duplicate(vec![1]);

	is_anagram::Solution::is_anagram(String::new(), String::new());

	group_anagrams::Solution::group_anagrams(vec![]);

	longest_consecutive_sequence::Solution::longest_consecutive(vec![]);

	longest_substring_without_repeating_characters::Solution::length_of_longest_substring("test".to_string());

	product_of_array_except_self::Solution::product_except_self(vec![]);

	remove_duplicates::Solution::remove_duplicates(&mut vec![1]);

	top_k_frequent_elements::Solution::top_k_frequent(vec![], 2);

	three_sum::Solution::three_sum(vec![]);

	two_sum::Solution::two_sum(vec![2,7,11,15], 22);

	two_sum_ii::Solution::two_sum(vec![2,7,11,15], 22);

	valid_palindrome::Solution::is_palindrome(String::new());

	valid_sudoku::Solution::is_valid_sudoku(vec![vec![]]);
}