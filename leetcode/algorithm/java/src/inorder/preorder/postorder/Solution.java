package inorder.preorder.postorder;

import java.util.ArrayList;

import util.tree.node.TreeNode;

public class Solution {

	ArrayList<Integer> inorders = new ArrayList<>(32);
	ArrayList<Integer> preorders = new ArrayList<>(32);
	ArrayList<Integer> postorders = new ArrayList<>(32);

	private void recurse(TreeNode curr) {
		if (curr == null) {
			return;
		}

		preorders.add(curr.val);

		recurse(curr.left);

		inorders.add(curr.val);

		recurse(curr.right);

		postorders.add(curr.val);
	}

	public int[][] threeOrders (TreeNode root) {

		recurse(root);

		int[][] results = new int[3][inorders.size()];

		results[0] = preorders.stream().mapToInt(Integer::intValue).toArray();
		results[1] = inorders.stream().mapToInt(Integer::intValue).toArray();
		results[2] = postorders.stream().mapToInt(Integer::intValue).toArray();

		return results;
	}
}