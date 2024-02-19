// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
	pub val: i32,
	pub next: Option<Box<ListNode>>
}
// 
impl ListNode {
	#[inline]
	fn new(val: i32) -> Self {
		ListNode {
			next: None,
			val
		}
	}

	fn from_slice(slice: &[i32]) -> Option<Box<ListNode>> {
		slice.split_first(
		).map(
			|(&first, rest)| {
				Box::new(
					ListNode {
						val: first,
						next: ListNode::from_slice(rest),
					}
				)
			}
		)
	}
}

pub struct Solution {
}

impl Solution {
	fn calc_digit(node1_val: i32, node2_val: i32, mut carry: bool) -> (i32, bool) {
		let mut curr_val = node1_val + node2_val;

		if carry {
			curr_val += 1;
		}

		if curr_val >= 10 {
			curr_val -= 10;
			carry = true;
		}
		else {
			carry = false;
		}

		(curr_val, carry)
	}

	pub fn add_two_numbers_helper(
		l1: &Option<Box<ListNode>>,
		l2: &Option<Box<ListNode>>,
		carry: bool
	) -> Option<Box<ListNode>> {

		match (&l1, &l2) {
			(None, None) => {
				if carry {
					Some(Box::new(ListNode::new(1)))
				}
				else {
					None
				}
			},
			(Some(node1), None) => {
				let result = Self::calc_digit(node1.val, 0, carry);

				let rest = Self::add_two_numbers_helper(&node1.next, &None, result.1);
				let mut curr_boxed_node = Box::new(ListNode::new(result.0));

				curr_boxed_node.next = rest;

				Some(curr_boxed_node)
			},
			(None, Some(node2)) => {
				let result = Self::calc_digit(0,node2.val,  carry);

				let rest = Self::add_two_numbers_helper(&None, &node2.next, result.1);
				let mut curr_boxed_node = Box::new(ListNode::new(result.0));

				curr_boxed_node.next = rest;

				Some(curr_boxed_node)
			},
			(Some(node1), Some(node2)) => {
				let result = Self::calc_digit(node1.val, node2.val, carry);

				let rest = Self::add_two_numbers_helper(&node1.next, &node2.next, result.1);
				let mut curr_boxed_node = Box::new(ListNode::new(result.0));

				curr_boxed_node.next = rest;

				Some(curr_boxed_node)
			},
		}
	}

	pub fn add_two_numbers(
		l1: Option<Box<ListNode>>, l2: Option<Box<ListNode>>
	) -> Option<Box<ListNode>> {
		Self::add_two_numbers_helper(&l1, &l2, false)
	}
}


#[cfg(test)]
mod tests {
use super::{ListNode, Solution};

	fn compare_lists(l1: &Option<Box<ListNode>>, l2: &Option<Box<ListNode>>) -> bool {
		/* verbose, non match ergonomics way to write:
		 * match (l1, l2) {
		 *	(&Some(ref node1), &Some(ref node2)) => {
		*/
		match (l1, l2) {
			(Some(node1), Some(node2)) => {
				if node1.val != node2.val {
					return false;
				}

				compare_lists(&node1.next, &node2.next)
			},
			(None, None) => true,
			_ => false,
		}
	}

	#[test]
	fn test_add_two_numbers() {
		println!("\n\ntest start\n\n");

		let num_0 = ListNode::from_slice(&[0]);
		let num_result = Solution::add_two_numbers(num_0.clone(), num_0.clone());
		let box_head_node = num_result.expect("Expect some, but was none");
		assert_eq!(box_head_node.as_ref().val, 0);
 
		let num_12345:Option<Box<ListNode>> = ListNode::from_slice(&[1, 2, 3, 4, 5]);
		let mut num_result = Solution::add_two_numbers(num_12345.clone(), num_12345.clone());
		if num_result.is_none() {
			panic!("Expect some, but was none");
		}
		let num_246801 = ListNode::from_slice(&[2, 4, 6, 8, 0, 1]);
		let mut num_result_cursor = &mut num_result;
		while let Some(num_ref) = num_result_cursor {
			println!("num_result element: {}", num_ref.val);
			num_result_cursor = &mut num_ref.next;
		}
		assert!(compare_lists(&num_result, &num_246801));

	 	let num_99999:Option<Box<ListNode>> = ListNode::from_slice(&[9, 9, 9, 9, 9]);
		let num_999:Option<Box<ListNode>> = ListNode::from_slice(&[9, 9, 9]);
		let mut num_result = Solution::add_two_numbers(num_99999, num_999);
		if num_result.is_none() {
			panic!("Expect some, but was none");
		}
		let num_899001 = ListNode::from_slice(&[8, 9, 9, 0, 0, 1]);
		let mut num_result_cursor = &mut num_result;
		while let Some(num_ref) = num_result_cursor {
			println!("num_result element: {}", num_ref.val);
			num_result_cursor = &mut num_ref.next;
		}
		assert!(compare_lists(&num_result, &num_899001));
	}
}