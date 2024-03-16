package invert.binary.tree;

import util.tree.node.TreeNode;

class Solution {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}

		TreeNode leftRoot = invertTree(root.left);

		TreeNode rightRoot = invertTree(root.right);

		root.left = rightRoot;
		root.right = leftRoot;

		return root;
	}
}