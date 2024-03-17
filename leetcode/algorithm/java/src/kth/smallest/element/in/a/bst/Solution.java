package kth.smallest.element.in.a.bst;

import java.util.LinkedList;
import java.util.List;

import util.tree.node.TreeNode;

class Solution {
	private List<Integer> nodes = new LinkedList<>();

	private void inOrderTraverse(TreeNode curr, int k) {
		if (nodes.size() == k) {
			return;
		}

		if (curr == null) {
			return;
		}

		inOrderTraverse(curr.left, k);
		nodes.add(curr.val);
		inOrderTraverse(curr.right, k);
	}

	public int kthSmallest(TreeNode root, int k) {

		if (root == null || k < 1) {
			return 0;
		}

		inOrderTraverse(root, k);

		return nodes.get(k - 1);
	}
}