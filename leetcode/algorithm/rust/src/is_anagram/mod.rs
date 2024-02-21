pub struct Solution {
}

impl Solution {
	pub fn is_anagram(s: String, t: String) -> bool {
		let mut letter_counts:[u32; 26] = [0; 26];

		let mut total_letter_count = 0;

		for c in s.chars() {
			let offset = (c as usize) - ('a' as usize);

			match letter_counts.get_mut(offset) {
				Some(count_ref) => *count_ref += 1,
				None => panic!("invalid input of character {}", c),
			}

			total_letter_count += 1;
		}

		for c in t.chars() {
			let offset = (c as usize) - ('a' as usize);

			match letter_counts.get_mut(offset) {
				Some(count_ref) =>{
					if *count_ref < 1 {
						return false;
					}

					*count_ref -= 1
				},
				None => panic!("invalid input of character {}", c),
			}

			total_letter_count -= 1;
		}

		total_letter_count == 0
	}
}

#[cfg(test)]
mod tests {
use super::Solution;


	#[test]
	fn test_is_anagram() {
		assert!(Solution::is_anagram("anagram".to_string(), "naagram".to_string()));

		assert!(!Solution::is_anagram("anabram".to_string(), "naagram".to_string()));
	}
}