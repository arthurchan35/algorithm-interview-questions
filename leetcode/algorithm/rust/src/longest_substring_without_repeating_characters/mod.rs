use std::collections::HashMap;

pub struct Solution {
}

impl Solution {
	pub fn length_of_longest_substring(s: String) -> i32 {

		if s.len() < 2 {
			return s.len() as i32;
		}

		let mut char_last_index_map:HashMap<char, usize> = HashMap::with_capacity(s.len());

		let mut left = 0;
		let mut max = 0;

		// question contins only ascii charaters, thus len() equals to the number of charaters

		for char_indice in s.char_indices() {

			if let Some(char_last_index) = char_last_index_map.insert(char_indice.1, char_indice.0 + 1) {
				if char_last_index >= left {
					left = char_last_index;
					continue;
				}
			}

			if char_indice.0 + 1 - left > max {
				max = char_indice.0 + 1 - left;
			}
		}

		max as i32
	}
}

#[cfg(test)]
mod tests {
	use super::Solution;

	#[test]
	fn test() {

		assert_eq!(4, Solution::length_of_longest_substring("dabcabcbb".to_string()));
		assert_eq!(1, Solution::length_of_longest_substring("bbbbb".to_string()));
		assert_eq!(3, Solution::length_of_longest_substring("pwwkew".to_string()));
		assert_eq!(2, Solution::length_of_longest_substring("au".to_string()));
		assert_eq!(5, Solution::length_of_longest_substring("tmmzuxt".to_string()));
	}
}