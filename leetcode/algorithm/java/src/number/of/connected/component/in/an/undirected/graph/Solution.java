package number.of.connected.component.in.an.undirected.graph;

import java.util.HashMap;
import java.util.HashSet;

class Solution {

	private int findAncestor(HashMap<Integer, Integer> parentMap, int current) {
		Integer parent = parentMap.get(current);
		if (parent == null) {
			parentMap.put(current, current);
			return current;
		}

		if (current == parent) {
			return current;
		}

		int ancestor = findAncestor(parentMap, parent);

		// path compression
		parentMap.put(current, ancestor);

		return ancestor;
	}

	public int countComponents(int n, int[][] edges) {
		HashMap<Integer, Integer> parentMap = new HashMap<>(n);

		// ideally we should keep track of a tree height for each tree of head node ancestor
		// but with path compression, some of the children path will be shrinked
		// thus it's impossible to track real height of a tree
		HashMap<Integer, Integer> treeHeightUpperBoundMap = new HashMap<>(n);

		HashSet<Integer> nodeInEdge = new HashSet<>(n);

		for (int i = 0; i < edges.length; ++i) {
			nodeInEdge.add(edges[i][0]);
			nodeInEdge.add(edges[i][1]);

			int ancestor0 = findAncestor(parentMap, edges[i][0]);
			int ancestor1 = findAncestor(parentMap, edges[i][1]);

			// both are newlly inserted, choose one to be parent for both
			if (ancestor0 == edges[i][0] && ancestor1 == edges[i][1]) {
				parentMap.put(edges[i][0], edges[i][0]);
				parentMap.put(edges[i][1], edges[i][0]);

				treeHeightUpperBoundMap.put(edges[i][0], 1);
				continue;
			}

			// one of them has no parent, set this one's parent to be the other's parent
			if (ancestor0 != edges[i][0] && ancestor1 == edges[i][1]) {
				parentMap.put(edges[i][1], ancestor0);
				continue;
			}

			// one of them has no parent, set this one's parent to be the other's parent
			if (ancestor0 == edges[i][0] && ancestor1 != edges[i][1]) {
				parentMap.put(edges[i][0], ancestor1);
				continue;
			}

			if (ancestor0 == ancestor1) {
				continue;
			}

			int treeHeightUpperBound0 = treeHeightUpperBoundMap.get(ancestor0);
			int treeHeightUpperBound1 = treeHeightUpperBoundMap.get(ancestor1);

			if (treeHeightUpperBound0 < treeHeightUpperBound1) {
				parentMap.put(edges[i][0], ancestor1);
			}
			else if (treeHeightUpperBound1 < treeHeightUpperBound0) {
				parentMap.put(edges[i][1], ancestor0);
			}
			else {
				parentMap.put(edges[i][0], ancestor1); // or parentMap.put(edges[i][1], ancestor0);
				treeHeightUpperBoundMap.put(ancestor1, treeHeightUpperBound0 + 1);
			}
		}

		for (int parent : parentMap.values()) {
			nodeInEdge.remove(findAncestor(parentMap, parent));
		}

		return n - nodeInEdge.size();
	}
}