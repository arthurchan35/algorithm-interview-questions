use std::cmp::Reverse;
use std::collections::HashMap;
use std::collections::BinaryHeap;
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

		let mut min_heap:BinaryHeap<Reverse<u32>> = BinaryHeap::with_capacity(k as usize);
		let mut count_to_elements_map: HashMap<u32, Vec<i32>> = HashMap::with_capacity(nums.len());

		for (element, count) in element_counts_map.into_iter() {

			match count_to_elements_map.get_mut(&count) {
				Some(vector) => {
					vector.push(element);
				},
				None => {
					count_to_elements_map.insert(count, vec![element]);
				},
			}

			if min_heap.len() < k as usize {
				min_heap.push(Reverse(count));

				continue;
			}

			if let Some(element_count) = min_heap.peek() {
				if element_count.0 < count {
					min_heap.pop();
					min_heap.push(Reverse(count));
				}
			}
		}

		let mut return_vector:Vec<i32> = Vec::with_capacity(k as usize);

		while !min_heap.is_empty() {
			if let Some(count) = min_heap.pop() {

				if let Some(vector) = count_to_elements_map.get_mut(&count.0) {

					let last_element = vector.remove(vector.len() - 1);

					return_vector.push(last_element);
				}
			}
		}

		return_vector
	}
}

#[cfg(test)]
mod tests {
	use super::Solution;
	use std::collections::HashSet;

	#[test]
	fn test() {
		let result =  Solution::top_k_frequent(vec![1, 1, 1, 1, 3, 3, 5, 5, 73], 4);

		println!("result: {:?}", result);

		let expected_set:HashSet<i32> = vec![1,3,5].into_iter().collect();

		assert!(result.len() == expected_set.len());

		for num in &result {
			assert!(expected_set.contains(num));
		}
	}
}