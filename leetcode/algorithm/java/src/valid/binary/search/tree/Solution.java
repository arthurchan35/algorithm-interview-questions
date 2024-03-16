package valid.binary.search.tree;

import util.tree.node.TreeNode;

class Solution {

	boolean valid = true;

	public int[] treeRange(TreeNode curr) {
		if (curr == null) {
			return null;
		}

		int[] currRange = new int[]{curr.val, curr.val};

		int[] subRange = treeRange(curr.left);

		if (subRange != null) {
			if (subRange[0] < currRange[0]) {
				currRange[0] = subRange[0];
			}
			if (subRange[1] >= curr.val) {
				currRange[1] = subRange[1];
				valid = false;
			}
		}

		subRange = treeRange(curr.right);

		if (subRange != null) {
			if (subRange[0] <= curr.val) {
				currRange[0] = subRange[0];
				valid = false;
			}

			if (subRange[1] > currRange[1]) {
				currRange[1] = subRange[1];
			}
		}

		return currRange;
	}

	public boolean isValidBST(TreeNode head) {

		treeRange(head);

		return valid;
	}
}