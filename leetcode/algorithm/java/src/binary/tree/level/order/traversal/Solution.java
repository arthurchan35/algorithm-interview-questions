package binary.tree.level.order.traversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.tree.node.TreeNode;

class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Deque<TreeNode> queue = new LinkedList<>();

		List<List<Integer>> results = new ArrayList<>();

		if (root == null) {
			return results;
		}

		// this is important, as it keeps track of number of nodes in a level
		// otherwise would know when a level is finished.
		// or one have insert a delimiter like null into queue to indicate a level is finished.
		int levelNodes = 1;

		queue.offerLast(root);

		while (!queue.isEmpty()) {
			List<Integer> result = new ArrayList<>(levelNodes);

			for (int i = 0; i < levelNodes; ++i) {
				TreeNode curr = queue.pollFirst();

				result.add(curr.val);

				if (curr.left != null) {
					queue.offerLast(curr.left);
				}
				if (curr.right != null) {
					queue.offerLast(curr.right);
				}
			}

			levelNodes = queue.size();
			results.add(result);
		}

		return results;
	}
}