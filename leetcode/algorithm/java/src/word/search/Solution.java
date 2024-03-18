package word.search;

class Solution {

	private boolean exist(char[][] board, int boardI, int boardJ, String word, int charIndex) {
		if (charIndex == word.length() - 1) {
			return true;
		}

		char nextChar = word.charAt(charIndex + 1);

		if (boardI < board.length - 1 && board[boardI + 1][boardJ] == nextChar) {
			board[boardI + 1][boardJ] = 0;
			boolean exist = exist(board, boardI + 1, boardJ, word, charIndex + 1);

			if (exist == true) {
				return true;
			}
			board[boardI + 1][boardJ] = nextChar;
		}

		if (boardI > 0 && board[boardI - 1][boardJ] == nextChar) {
			board[boardI - 1][boardJ] = 0;
			boolean exist = exist(board, boardI - 1, boardJ, word, charIndex + 1);

			if (exist == true) {
				return true;
			}
			board[boardI - 1][boardJ] = nextChar;
		}

		if (boardJ < board[0].length - 1 && board[boardI][boardJ + 1] == nextChar) {
			board[boardI][boardJ + 1] = 0;
			boolean exist = exist(board, boardI, boardJ + 1, word, charIndex + 1);

			if (exist == true) {
				return true;
			}
			board[boardI][boardJ + 1] = nextChar;
		}

		if (boardJ > 0 && board[boardI][boardJ - 1] == nextChar) {
			board[boardI][boardJ - 1] = 0;
			boolean exist = exist(board, boardI, boardJ - 1, word, charIndex + 1);

			if (exist == true) {
				return true;
			}
			board[boardI][boardJ - 1] = nextChar;
		}

		return false;
	}

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {

				if (board[i][j] == word.charAt(0)) {
					board[i][j] = 0;
					if (exist(board, i, j, word, 0)) {
						return true;
					}
					board[i][j] = word.charAt(0);
				}

			}
		}
		return false;
	}
}