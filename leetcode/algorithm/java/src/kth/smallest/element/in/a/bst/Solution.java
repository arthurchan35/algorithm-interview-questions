package kth.smallest.element.in.a.bst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.tree.node.TreeNode;

// if the problem becomes an online problem that tree could be modified
// we need a max priority queue with size set to k
// if the tree exists, then traverse the tree and
//		get the k smallest elements and insert them into priority queue
//		O(kLogN) time complexity
// if a node bigger than kth smallest node is inserted into the tree, nothing happens to the priority queue
// if a node smaller than kth smallest node is inserted into the tree,
// insert the node into priority queue and pop the biggest node (k + 1)th from priority queue
//		O(2Logn) time compleixity
// simliar to delete operation
// get kth smallest element is always constant time
class Solution {
	private List<Integer> nodes = new LinkedList<>();

	private void inOrderTraverseRecursive(TreeNode curr, int k) {
		if (nodes.size() == k) {
			return;
		}

		if (curr == null) {
			return;
		}

		inOrderTraverseRecursive(curr.left, k);
		nodes.add(curr.val);
		inOrderTraverseRecursive(curr.right, k);
	}

	/*
	 * 					6
	 * 		3						9
	 * 2		4			7
	 * 				5			8
	 */

	 Deque<TreeNode> stack = new ArrayDeque<>();

	 private void inOrderTraverseIterative(TreeNode curr, int k) {
		while (true) {
			while (curr != null) {
				stack.offerLast(curr);
				curr = curr.left;
			}

			if (stack.isEmpty()) {
				return;
			}

			if (nodes.size() == k) {
				return;
			}

			curr = stack.pollLast();
			nodes.add(curr.val);
			curr = curr.right;
		}
	}

	public int kthSmallest(TreeNode root, int k) {

		if (root == null || k < 1) {
			return 0;
		}

		inOrderTraverseIterative(root, k);

		return nodes.get(k - 1);
	}
}