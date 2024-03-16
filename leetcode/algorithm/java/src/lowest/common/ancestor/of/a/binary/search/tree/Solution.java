package lowest.common.ancestor.of.a.binary.search.tree;

import util.tree.node.TreeNode;

class Solution {

	// since bst makes sure
	// smaller nodes must be in the left sub tree,
	// bigger nodes must be in the right sub tree.
	// when p and q are one bigger and one smaller, then the root must be the lca
	// when p and q are both smaller or both bigger, then search one of sub tree depending on bigger or smaller.

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val < root.val) {
			if (q.val < root.val) {
				return lowestCommonAncestor(root.left, p, q);
			}
			return root;
		}

		if (p.val > root.val) {
			if (q.val > root.val) {
				return lowestCommonAncestor(root.right, p, q);
			}
			return root;
		}

		return p;
	}
}