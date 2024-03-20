package number.of.islands;

class Solution {

	private int count = 0;

	private void sinkIsland(char[][] grid, int i, int j) {
		if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
			return;
		}

		if (grid[i][j] == '0' || grid[i][j] == 0) {
			return;
		}

		grid[i][j] = 0;

		sinkIsland(grid, i + 1, j);
		sinkIsland(grid, i - 1, j);
		sinkIsland(grid, i, j + 1);
		sinkIsland(grid, i, j - 1);
	}

	public int numIslands(char[][] grid) {
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[0].length; ++j) {
				if (grid[i][j] == '1') {
					count += 1;
					sinkIsland(grid, i, j);
				}
			}
		}
		return count;
	}
}