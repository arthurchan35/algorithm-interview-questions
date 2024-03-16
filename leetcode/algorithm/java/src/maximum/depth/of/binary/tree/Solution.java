package maximum.depth.of.binary.tree;

import util.tree.node.TreeNode;

class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int maxLeft = maxDepth(root.left);
		int maxRight = maxDepth(root.right);

		if (maxLeft > maxRight) {
			return maxLeft + 1;
		}
		else {
			return maxRight + 1;
		}
	}
}