package maximal.square;

import java.util.Arrays;

class Solution {

	int[][] maximalSquare;

	private int expandMaximalSquare(int i, int j, char[][] matrix) {

		if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0') {
			return 0;
		}

		if (maximalSquare[i][j] > 0) {
			return maximalSquare[i][j];
		}

		if (i == matrix.length - 1 || j == matrix[0].length - 1) {
			maximalSquare[i][j] = matrix[i][j] == '1' ? 1 : 0;
			return maximalSquare[i][j];
		}

		int subLength = expandMaximalSquare(i + 1, j + 1, matrix);

		if (subLength == 0) {
			maximalSquare[i][j] = matrix[i][j] == '1' ? 1 : 0;

			return maximalSquare[i][j];
		}

		for (int l = 1; l <= subLength; ++l) {
			if (matrix[l + i][j] == '0') {
				maximalSquare[i][j] = l;
				return maximalSquare[i][j];
			}
			if (matrix[i][l + j] == '0') {
				maximalSquare[i][j] = l;
				return maximalSquare[i][j];
			}

		}

		maximalSquare[i][j] = subLength + 1;
		return maximalSquare[i][j];
	}

	public int maximalSquare(char[][] matrix) {

		maximalSquare = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; ++i) {
			Arrays.fill(maximalSquare[i], -1);
		}

		int maxLength = 0;

		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; ++j) {
				int currLength = expandMaximalSquare(i, j, matrix);

				if (currLength > maxLength) {
					maxLength = currLength;
				}
			}
		}

		return maxLength * maxLength;
	}
}