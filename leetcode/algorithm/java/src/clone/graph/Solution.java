package clone.graph;

import java.util.HashMap;

import util.graph.node.Node;

class Solution {

	HashMap<Node, Node> originToCopy = new HashMap<>();

	private void helper(Node node) {
		if (originToCopy.containsKey(node)) {
			return;
		}

		Node copy = new Node(node.val);

		originToCopy.put(node, copy);

		for (Node neighbor : node.neighbors) {
			Node copiedNeighbor = originToCopy.get(neighbor);

			if (copiedNeighbor == null) {
				helper(neighbor);
				copiedNeighbor = originToCopy.get(neighbor);
			}

			copy.neighbors.add(copiedNeighbor);
		}
	}

	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}

		helper(node);

		return originToCopy.get(node);
	}
}