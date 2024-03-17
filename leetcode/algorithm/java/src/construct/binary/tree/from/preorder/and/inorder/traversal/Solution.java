package construct.binary.tree.from.preorder.and.inorder.traversal;

import util.tree.node.TreeNode;

/*
 * 						6
 * 			4						8
 * 		3		5			7			9
 * 2
 * 			  0 1 2 3 4 5 6 7 8
 *			  s l       r     e
 * preOrder = 6 4 3 2 5 8 7 9
 * 
 * 			  0 1 2 3 4 5 6 7 8
 *            s       c r     e
 * inOrder  = 2 3 4 5 6 7 8 9
 * 
 * 
 * 					1
 * 		2
 * 			3
 * 
 * 			  0  1  2  3
 *			  s        e
 * preOrder = 1  2  3
 * 
 * 			  0  1  2  3
 *            s        e
 * inOrder  = 2  3  1
 * 
 * 
 *  *  * 	  0  1  2
 *			  s     e
 * preOrder = 1  2
 *            s     e
 * inOrder  = 1  2

 */
class Solution {
	private int indexOfInC(int[] inorder, int s, int e, int inCValue) {
		for (int i = s; i < e; ++i) {
			if (inorder[i] == inCValue) {
				return i;
			}
		}

		return -1;
	}

	private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {

		System.out.println("entering: ps: " + ps + " pe: " + pe + " is: " + is + " ie: " + ie);

		int inC = indexOfInC(inorder, is, ie, preorder[ps]);
		int leftLength = inC - is;

		int inR = inC + 1;
		int preL = ps + 1;
		int preR = preL + leftLength;

		System.out.println("calc: inC: " + inC + " inR: " + inR + " preR: " + preR);

		TreeNode leftSubTree = null;
		if (inC > is) {
			System.out.println("into left");
			leftSubTree = buildTree(preorder, preL, preR, inorder, is, inC);
		}

		TreeNode rightSubTree = null;
		if (inR < ie) {
			System.out.println("into right");
			rightSubTree = buildTree(preorder, preR, pe, inorder, inR, ie);
		}

		return new TreeNode(preorder[ps], leftSubTree, rightSubTree);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
	}
}