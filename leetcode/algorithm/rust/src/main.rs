mod add_two_numbers;
mod contains_duplicate;
mod group_anagrams;
mod is_anagram;
mod longest_consecutive_sequence;
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

	contains_duplicate::Solution::contains_duplicate(vec![1]);

	is_anagram::Solution::is_anagram(String::new(), String::new());

	group_anagrams::Solution::group_anagrams(vec![]);

	longest_consecutive_sequence::Solution::longest_consecutive(vec![]);

	product_of_array_except_self::Solution::product_except_self(vec![]);

	remove_duplicates::Solution::remove_duplicates(&mut vec![1]);

	top_k_frequent_elements::Solution::top_k_frequent(vec![], 2);

	three_sum::Solution::three_sum(vec![]);

	two_sum::Solution::two_sum(vec![2,7,11,15], 22);

	two_sum_ii::Solution::two_sum(vec![2,7,11,15], 22);

	valid_palindrome::Solution::is_palindrome(String::new());

	valid_sudoku::Solution::is_valid_sudoku(vec![vec![]]);
}