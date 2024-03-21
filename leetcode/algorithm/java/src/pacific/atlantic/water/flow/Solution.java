package pacific.atlantic.water.flow;

import java.util.ArrayList;
import java.util.List;

class Solution {

	Boolean[][] pacificReachable;
	Boolean[][] atlanticReachable;

	boolean[][] currentPathVisited;

	private boolean pacificReachable(int[][] heights, int i, int j) {
		if (i >= heights.length || j >= heights[0].length) {
			return false;
		}

		if (pacificReachable[i][j] != null) {
			return pacificReachable[i][j];
		}

		if (currentPathVisited[i][j]) {
			return false;
		}

		// when a place is not determined, and asks for a result from next slot
		// and if next is also not determined, the next one may asks for a result from previous one
		currentPathVisited[i][j] = true;

		boolean upper = pacificReachable(heights, i - 1, j);

		if (upper) {
			if (heights[i][j] >= heights[i - 1][j]) {
				pacificReachable[i][j] = true;

				// backtracking, when current place is returned, it defintely
				// will have a result, clear current visited.
				currentPathVisited[i][j] = false;
				return true;
			}
		}

		boolean left = pacificReachable(heights, i, j - 1);

		if (left) {
			if (heights[i][j] >= heights[i][j - 1]) {
				pacificReachable[i][j] = true;

				// backtracking
				currentPathVisited[i][j] = false;
				return true;
			}
		}

		boolean lower = pacificReachable(heights, i + 1, j);

		if (lower) {
			if (heights[i][j] >= heights[i + 1][j]) {
				pacificReachable[i][j] = true;

				// backtracking
				currentPathVisited[i][j] = false;
				return true;
			}
		}

		boolean right = pacificReachable(heights, i, j + 1);

		if (right) {
			if (heights[i][j] >= heights[i][j + 1]) {
				pacificReachable[i][j] = true;

				// backtracking
				currentPathVisited[i][j] = false;
				return true;
			}
		}

		// backtracking
		currentPathVisited[i][j] = false;
		return false;
	}

	private boolean atlanticReachable(int[][] heights, int i, int j) {
		if (i < 0 || j < 0) {
			return false;
		}

		if (atlanticReachable[i][j] != null) {
			return atlanticReachable[i][j];
		}

		if (currentPathVisited[i][j]) {
			return false;
		}

		// backtracking
		currentPathVisited[i][j] = true;

		boolean lower = atlanticReachable(heights, i + 1, j);

		if (lower) {
			if (heights[i][j] >= heights[i + 1][j]) {
				atlanticReachable[i][j] = true;

				currentPathVisited[i][j] = false;
				return true;
			}
		}

		boolean right = atlanticReachable(heights, i, j + 1);

		if (right) {
			if (heights[i][j] >= heights[i][j + 1]) {
				atlanticReachable[i][j] = true;

				currentPathVisited[i][j] = false;
				return true;
			}
		}

		boolean upper = atlanticReachable(heights, i - 1, j);

		if (upper) {
			if (heights[i][j] >= heights[i - 1][j]) {
				pacificReachable[i][j] = true;

				currentPathVisited[i][j] = false;
				return true;
			}
		}

		boolean left = atlanticReachable(heights, i, j - 1);

		if (left) {
			if (heights[i][j] >= heights[i][j - 1]) {
				atlanticReachable[i][j] = true;

				currentPathVisited[i][j] = false;
				return true;
			}
		}

		currentPathVisited[i][j] = false;
		return false;
	}

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		pacificReachable = new Boolean[heights.length][heights[0].length];
		atlanticReachable = new Boolean[heights.length][heights[0].length];
		currentPathVisited = new boolean[heights.length][heights[0].length];

		List<List<Integer>> results = new ArrayList<>(heights.length);

		for (int j = 0; j < heights[0].length; ++j) {
			pacificReachable[0][j] = true;
			atlanticReachable[heights.length - 1][j] = true;
		}
		for (int i = 0; i < heights.length; ++i) {
			pacificReachable[i][0] = true;
			atlanticReachable[i][heights[0].length - 1] = true;
		}

		for (int i = 0; i < heights.length; ++i) {
			for (int j = 0; j < heights[0].length; ++j) {
				if (pacificReachable(heights, i, j) && atlanticReachable(heights, i, j)) {
					results.add(List.of(i, j));
				}
			}
		}

		return results;
	}
}