package subtree.of.another;

import util.tree.node.TreeNode;

class Solution {

	private boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if (p == null && q != null) {
			return false;
		}

		if (p != null && q == null) {
			return false;
		}

		if (p.val != q.val) {
			return false;
		}

		boolean isLeftSame = isSameTree(p.left, q.left);

		if (!isLeftSame) {
			return false;
		}

		return isSameTree(p.right, q.right);
	}

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {

		if (isSameTree(root, subRoot)) {
			return true;
		}

		if (root == null) {
			return false;
		}

		if (isSubtree(root.left, subRoot)) {
			return true;
		}

		if (isSubtree(root.right, subRoot)) {
			return true;
		}

		return false;
	}
}