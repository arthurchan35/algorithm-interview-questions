package valid.binary.search.tree;

import util.tree.node.TreeNode;

class Solution {

	private boolean isValidBST(TreeNode curr, TreeNode lowerBound, TreeNode upperBound) {
		if (curr == null) {
			return true;
		}

		if (lowerBound != null && lowerBound.val >= curr.val) {
			return false;
		}
		if (upperBound != null && upperBound.val <= curr.val) {
			return false;
		}

		if (!isValidBST(curr.left, lowerBound, curr)) {
			return false;
		}

		if (!isValidBST(curr.right, curr, upperBound)) {
			return false;
		}

		return true;
	}

	public boolean isValidBST(TreeNode head) {
		return isValidBST(head, null, null);
	}
}