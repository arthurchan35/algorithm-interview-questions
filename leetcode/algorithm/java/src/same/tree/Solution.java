package same.tree;

import util.tree.node.TreeNode;

class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null && q != null) {
			return false;
		}
		if (q == null && p != null) {
			return false;
		}

		if (q.val != p.val) {
			return false;
		}

		boolean sameLeft = isSameTree(p.left, q.left);

		if (!sameLeft) {
			return false;
		}

		return isSameTree(p.right, q.right);
	}
}