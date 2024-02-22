use std::collections::HashMap;

pub struct Solution {
}

impl Solution {
	pub fn group_anagrams(strs: Vec<String>) -> Vec<Vec<String>> {
		let mut sorted_to_originals_map: HashMap<[u8; 26], Vec<String>> = HashMap::with_capacity(strs.len());

		for word in &strs {
			let mut letter_counts:[u8; 26] = [0; 26];

			for c in word.chars() {
				letter_counts[c as usize - 'a' as usize] += 1;
			}

			match sorted_to_originals_map.get_mut(&letter_counts) {
				Some(vect) => vect.push(word.clone()),
				None => {
					sorted_to_originals_map.insert(letter_counts, vec![word.clone()]);

					letter_counts[1] += 1;
				},
			}
		}

		sorted_to_originals_map.into_values().collect()
	}
}

#[cfg(test)]
mod tests {
	use super::Solution;
	use crate::is_anagram;

	#[test]
	fn test_two_sum() {
		let inputs = vec!["eat".to_string(),"tea".to_string(),"tan".to_string(),"ate".to_string(),"nat".to_string(),"bat".to_string()];

		let result = Solution::group_anagrams(inputs);

		for vect in &result {

			let first_word = &vect[0];

			for word in vect {
				assert!(is_anagram::Solution::is_anagram(first_word.clone(), word.clone()));
			}
		}

		println!("result {:?}", result);
	}
}