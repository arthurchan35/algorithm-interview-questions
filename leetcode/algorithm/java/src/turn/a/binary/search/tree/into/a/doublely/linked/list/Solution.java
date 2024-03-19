package turn.a.binary.search.tree.into.a.doublely.linked.list;

import util.tree.node.TreeNode;

public class Solution {

	private void helper(TreeNode curr, TreeNode[] headTail) {
		headTail[0] = null;
		headTail[1] = null;

		if (curr == null) {
			return;
		}

		 helper(curr.left, headTail);

		 TreeNode head = headTail[0];

		 if (head == null) {
			head = curr;
		 }

		 if (headTail[1] != null) {
			headTail[1].right = curr;
			curr.left = headTail[1];
		}

		helper(curr.right, headTail);

		TreeNode tail = headTail[1];

		if (tail == null) {
			tail = curr;
		}

		if (headTail[0] != null) {
			headTail[0].left = curr;
			curr.right = headTail[0];
		}

		headTail[0] = head;
		headTail[1] = tail;
	}
	public TreeNode convert(TreeNode root) {
		TreeNode[] headTail = new TreeNode[2];

		helper(root, headTail);

		return headTail[0];
	}
}