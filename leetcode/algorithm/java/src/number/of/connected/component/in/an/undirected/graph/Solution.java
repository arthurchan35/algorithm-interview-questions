package number.of.connected.component.in.an.undirected.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
	public int countComponents(int n, int[][] edges) {
		HashMap<Integer, Integer> ancestorMap = new HashMap<>(n);

		HashMap<Integer, ArrayList<Integer>> descendantMap = new HashMap<>(n);

		HashSet<Integer> nodeInEdge = new HashSet<>(n);

		for (int i = 0; i < edges.length; ++i) {
			nodeInEdge.add(edges[i][0]);
			nodeInEdge.add(edges[i][1]);

			Integer ancestor0 = ancestorMap.get(edges[i][0]);
			Integer ancestor1 = ancestorMap.get(edges[i][1]);

			// both are newlly inserted, choose one to be ancestor for both
			if (ancestor0 == null && ancestor1 == null) {
				ancestorMap.put(edges[i][0], edges[i][0]);
				ancestorMap.put(edges[i][1], edges[i][0]);

				var descendants =
					descendantMap.computeIfAbsent(edges[i][0], key -> new ArrayList<>(n));
				descendants.add(edges[i][0]);
				descendants.add(edges[i][1]);

				continue;
			}

			// one of them has no ancestor, set this one's ancestor to be the other's ancestor
			if (ancestor0 != null && ancestor1 == null) {
				ancestorMap.put(edges[i][1], ancestor0);

				var descendants = descendantMap.get(ancestor0);
				descendants.add(edges[i][1]);

				continue;
			}

			// one of them has no ancestor, set this one's ancestor to be the other's ancestor
			if (ancestor1 != null && ancestor0 == null) {
				ancestorMap.put(edges[i][0], ancestor1);

				var descendants = descendantMap.get(ancestor1);
				descendants.add(edges[i][0]);

				continue;
			}

			if (ancestor0 == ancestor1) {
				continue;
			}

			var descendants0 = descendantMap.get(ancestor0);
			var descendants1 = descendantMap.get(ancestor1);

			if (descendants0.size() < descendants1.size()) {
				for (int descendant : descendants0) {
					ancestorMap.put(descendant, ancestor1);
				}

				descendantMap.remove(ancestor0);
				descendants1.addAll(descendants0);
			}
			else {
				for (int descendant : descendants1) {
					ancestorMap.put(descendant, ancestor0);
				}

				descendantMap.remove(ancestor1);
				descendants0.addAll(descendants1);
			}
		}

		return descendantMap.size() + n - nodeInEdge.size();
	}
}
