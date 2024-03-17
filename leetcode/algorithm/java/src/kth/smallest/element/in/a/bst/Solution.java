package kth.smallest.element.in.a.bst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.tree.node.TreeNode;

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