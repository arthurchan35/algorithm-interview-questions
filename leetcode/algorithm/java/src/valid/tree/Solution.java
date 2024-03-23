package valid.tree;

import java.util.HashMap;
import java.util.HashSet;

class Solution {

	private Integer findAncestor(HashMap<Integer, Integer> parentMap, Integer current) {

		Integer parent = parentMap.get(current);

		if (parent == null) {
			parentMap.put(current, current);
			return current;
		}

		if (parent == current) {
			return current;
		}

		Integer ancestor = findAncestor(parentMap, parent);

		if (ancestor != parent)
			parentMap.put(current, ancestor);

		return ancestor;
	}

	public boolean validTree(int n, int[][] edges) {

		if (n == 1 && edges.length < 1) {
			return true;
		}

		HashMap<Integer, Integer> parentMap = new HashMap<>(n);

		HashSet<Integer> nodesInEdges = new HashSet<>(n);

		for (int i = 0; i < edges.length; ++i) {
			Integer ancestor0 = findAncestor(parentMap, edges[i][0]);
			Integer ancestor1 = findAncestor(parentMap, edges[i][1]);

			nodesInEdges.add(edges[i][0]);
			nodesInEdges.add(edges[i][1]);

			if (ancestor0 == ancestor1) {
				return false;
			}

			if (ancestor0 == edges[i][0] && ancestor1 == edges[i][1]) {
				parentMap.put(edges[i][0], ancestor1);
				continue;
			}
			if (ancestor0 != edges[i][0] && ancestor1 == edges[i][1]) {
				parentMap.put(edges[i][1], ancestor0);
				continue;
			}
			if (ancestor0 == edges[i][0] && ancestor1 != edges[i][1]) {
				parentMap.put(edges[i][0], ancestor1);
				continue;
			}

			parentMap.put(edges[i][0], ancestor1);
		}

		if (n > nodesInEdges.size()) {
			return false;
		}

		int firstAncestor = findAncestor(parentMap, edges[0][0]);

		for (int parent : parentMap.values()) {
			if (firstAncestor != findAncestor(parentMap, parent)) {
				return false;
			}
		}

		return true;
	}
}