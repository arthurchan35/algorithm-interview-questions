package maximal.square;

class Solution {

	private int expandMaximalSquare(int i, int j, char[][] matrix) {

		if (i >= matrix.length || j >= matrix[0].length || matrix[i][j] == '0') {
			return 0;
		}

		if (i == matrix.length - 1 || j == matrix[0].length - 1) {
			return matrix[i][j] == '1' ? 1 : 0;
		}

		int subLength = expandMaximalSquare(i + 1, j + 1, matrix);

		if (subLength == 0) {
			return matrix[i][j] == '1' ? 1 : 0;
		}

		for (int l = 1; l <= subLength; ++l) {
			if (matrix[l + i][j] == '0') {
				return l;
			}
			if (matrix[i][l + j] == '0') {
				return l;
			}

		}

		return subLength + 1;
	}

	public int maximalSquare(char[][] matrix) {

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