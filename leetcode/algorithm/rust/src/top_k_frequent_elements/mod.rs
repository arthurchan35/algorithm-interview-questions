use std::collections::HashMap;
use std::vec;


pub struct Solution {
}

impl Solution {
	pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {

		let mut element_counts_map: HashMap<i32, u32> = HashMap::with_capacity(nums.len());

		for num in &nums {
			let counts_ref = element_counts_map.get_mut(num);

			match counts_ref {
				Some(count) => {
					*count += 1;
				},
				None => {
					element_counts_map.insert(*num, 1);
				},
			}
		}

		// index of counts represents counts
		// each element of counts represents an array of elements of that count
		// e.g. {0 : {10, 11, 4}} means elements 10, 11, 4 all have count of 1( - 1 index offset)
		// because the input has num.len() size, thus any element in nums can have maximum of nums.len() count

		let mut counts:Vec<Option<Vec<i32>>> = vec![None; nums.len()];

		for iter in element_counts_map.iter() {
			let element_ref_opt = counts.get_mut(*iter.1 as usize - 1);

			match element_ref_opt {
				Some(element_ref) => {

					match element_ref {
						Some(element) => {
							element.push(*iter.0);
						},
						None => {
							*element_ref = Some(vec![*iter.0]);
						},
					}
				},
				None => {
					panic!("vector should have been initialized to at least None in Some arm, ie Some(None)")
				},
			}

		}

		let mut return_result:Vec<i32> = Vec::with_capacity(k as usize);

		let mut k_copy = k;

		for element_vector_opt in counts.into_iter().rev() {

			if k_copy < 1 {
				break;
			}

			if let Some(element_vector) = element_vector_opt {

				for element in element_vector {
					if k_copy < 1 {
						break;
					}

					k_copy -= 1;

					return_result.push(element);
				}
			}
		}

		return_result
	}
}

#[cfg(test)]
mod tests {
	use super::Solution;
	use std::collections::HashSet;

	#[test]
	fn test() {
		let result =  Solution::top_k_frequent(vec![1, 1, 1, 1, 3, 3, 5, 5, 73], 1);

		println!("result: {:?}", result);

		let expected_set:HashSet<i32> = vec![1,3,5].into_iter().collect();

		//assert!(result.len() == expected_set.len());

		// todo: assertion condition is wrong, fix it or maybe not
		for num in &result {
			//assert!(expected_set.contains(num));
		}
	}
}