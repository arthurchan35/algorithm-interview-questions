package pacific.atlantic.water.flow;

import java.util.ArrayList;
import java.util.List;

class Solution {

	Boolean[][] pacificReachable;
	Boolean[][] atlanticReachable;

	boolean[][] inCurrentPath;

	private void printAtlanticReachable() {
        for (int i = 0; i < atlanticReachable.length; ++i) {
            for (int j = 0; j< atlanticReachable[0].length; ++j) {
				boolean r = atlanticReachable[i][j];
                System.out.print(r ? "t " : "f ");
            }
            System.out.println();
        }
    }

	private void printPacificReachable() {
        for (int i = 0; i < pacificReachable.length; ++i) {
            for (int j = 0; j< pacificReachable[0].length; ++j) {
				boolean r = pacificReachable[i][j];
                System.out.print(r ? "t " : "f ");
            }
            System.out.println();
        }
    }

	private void atlanticReachable(int[][] heights, int i, int j) {
		if (atlanticReachable[i][j] != null) {
			return;
		}

		if (inCurrentPath[i][j]) {
			return;
		}

		if (i == heights.length - 1 || j == heights[0].length - 1) {
			atlanticReachable[i][j] = true;
			return;
		}

		inCurrentPath[i][j] = true;

		if (i == 3 && j == 27) {
			System.out.println("entering i = 3, j = 27");
			System.out.println("in current path left = " + inCurrentPath[i][j - 1]);
			System.out.println("in current path upper = " + inCurrentPath[i - 1][j]);
			System.out.println("in current path right = " + inCurrentPath[i][j + 1]);
			System.out.println("in current path lower = " + inCurrentPath[i + 1][j]);
			System.out.println("atlanticReachab left = " + atlanticReachable[i][j - 1]);
			System.out.println("atlanticReachab upper = " + atlanticReachable[i - 1][j]);
			System.out.println("atlanticReachab right = " + atlanticReachable[i][j + 1]);
			System.out.println("atlanticReachab lower = " + atlanticReachable[i + 1][j]);
		}

		if (heights[i][j] >= heights[i + 1][j] && !inCurrentPath[i + 1][j]) {
			atlanticReachable(heights, i + 1, j);

			if (atlanticReachable[i + 1][j]) {
				atlanticReachable[i][j] = true;

				// backtracking
				inCurrentPath[i][j] = false;
				return;
			}
		}

		if (heights[i][j] >= heights[i][j + 1] && !inCurrentPath[i][j + 1]) {
			atlanticReachable(heights, i, j + 1);

			if (atlanticReachable[i][j + 1]) {
				atlanticReachable[i][j] = true;

				// backtracking
				inCurrentPath[i][j] = false;
				return;
			}
		}

		if (i > 0 && heights[i][j] >= heights[i - 1][j] && !inCurrentPath[i - 1][j]) {
			atlanticReachable(heights, i - 1, j);

			if (atlanticReachable[i - 1][j]) {
				atlanticReachable[i][j] = true;

				// backtracking
				inCurrentPath[i][j] = false;
				return;
			}
		}

		if (j > 0 && heights[i][j] >= heights[i][j - 1] && !inCurrentPath[i][j - 1]) {
			atlanticReachable(heights, i, j - 1);

			if (atlanticReachable[i][j - 1]) {
				atlanticReachable[i][j] = true;

				// backtracking
				inCurrentPath[i][j] = false;
				return;
			}
		}
		
		// backtracking
		inCurrentPath[i][j] = false;
		atlanticReachable[i][j] = false;
	}

	private void pacificReachable(int[][] heights, int i, int j) {
		if (pacificReachable[i][j] != null) {
			return;
		}

		if (inCurrentPath[i][j]) {
			return;
		}

		if (i == 0 || j == 0) {
			pacificReachable[i][j] = true;
			return;
		}

		inCurrentPath[i][j] = true;

		if (heights[i][j] >= heights[i - 1][j] && !inCurrentPath[i - 1][j]) {
			pacificReachable(heights, i - 1, j);

			if (pacificReachable[i - 1][j]) {
				pacificReachable[i][j] = true;

				// backtracking
				inCurrentPath[i][j] = false;
				return;
			}
		}

		if (heights[i][j] >= heights[i][j - 1] && !inCurrentPath[i][j - 1]) {
			pacificReachable(heights, i, j - 1);

			if (pacificReachable[i][j - 1]) {
				pacificReachable[i][j] = true;

				// backtracking
				inCurrentPath[i][j] = false;
				return;
			}
		}

		if (i < heights.length - 1 && heights[i][j] >= heights[i + 1][j] && !inCurrentPath[i + 1][j]) {
			pacificReachable(heights, i + 1, j);

			if (pacificReachable[i + 1][j]) {
				pacificReachable[i][j] = true;

				// backtracking
				inCurrentPath[i][j] = false;
				return;
			}
		}

		if (j < heights[0].length - 1 && heights[i][j] >= heights[i][j + 1] && !inCurrentPath[i][j + 1]) {
			pacificReachable(heights, i, j + 1);

			if (pacificReachable[i][j + 1]) {
				pacificReachable[i][j] = true;

				// backtracking
				inCurrentPath[i][j] = false;
				return;
			}
		}

		// backtracking
		inCurrentPath[i][j] = false;
		pacificReachable[i][j] = false;
	}

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		pacificReachable = new Boolean[heights.length][heights[0].length];
		atlanticReachable = new Boolean[heights.length][heights[0].length];
		inCurrentPath = new boolean[heights.length][heights[0].length];

		List<List<Integer>> results = new ArrayList<>(heights.length);

		for (int i = 0; i < heights.length; ++i) {
			for (int j = 0; j < heights[0].length; ++j) {
				pacificReachable(heights, i, j);
				atlanticReachable(heights, i, j);

				if (pacificReachable[i][j] && atlanticReachable[i][j]) {
					results.add(List.of(i, j));
				}
			}
		}

		printAtlanticReachable();
		System.out.println("------------------------------------------------------------------------");
		printPacificReachable();
		return results;
	}
}