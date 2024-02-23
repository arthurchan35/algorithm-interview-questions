use std::cmp::Ordering;
use std::collections::HashMap;
use std::collections::BinaryHeap;


#[derive(Eq, PartialEq)]
#[derive(Debug)]
struct ElementCount {
	element: i32,
	count: u32
}

impl Ord for ElementCount {
	fn cmp(&self, other: &Self) -> std::cmp::Ordering {
		other.count.cmp(&self.count)
	}
}

impl PartialOrd for ElementCount {
	fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
		Some(self.cmp(other))
	}
}

pub struct Solution {
}

impl Solution {
	pub fn top_k_frequent(nums: Vec<i32>, k: i32) -> Vec<i32> {

		let mut element_counts_map: HashMap<i32, ElementCount> = HashMap::with_capacity(nums.len());

		for num in &nums {
			let counts_ref = element_counts_map.get_mut(num);

			match counts_ref {
				Some(item) => {
					item.count += 1;
				},
				None => {
					element_counts_map.insert(*num, ElementCount {element: *num, count: 1});
				},
			}
		}

		let mut min_heap:BinaryHeap<ElementCount> = BinaryHeap::with_capacity(k as usize);

		for value in element_counts_map.into_values() {

			if min_heap.len() < k as usize {
				min_heap.push(value);

				continue;
			}

			if let Some(element_count) = min_heap.peek() {
				if element_count.count < value.count {
					min_heap.pop();
					min_heap.push(value);
				}
			}
		}

		min_heap.iter().map(
			|element_count| -> i32 {
				element_count.element
			}
		).collect::<Vec<i32>>()

	}
}

#[cfg(test)]
mod tests {
	use super::Solution;
	use std::collections::HashSet;

	#[test]
	fn test() {
		let result =  Solution::top_k_frequent(vec![4, 3, 2, 1, 3, 2, 1, 2, 1, 1], 3);

		println!("result: {:?}", result);

		let expected_set:HashSet<i32> = vec![1,2,3].into_iter().collect();

		assert!(result.len() == expected_set.len());

		for num in &result {
			assert!(expected_set.contains(num));
		}
	}
}