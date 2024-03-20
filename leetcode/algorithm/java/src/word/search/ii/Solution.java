package word.search.ii;

import java.util.ArrayList;
import java.util.List;
import implement.trie.Trie;
class Solution {

	Trie trie = new Trie();

	List<String> foundWords;

	void helper(char[][] board, int i, int j) {
		if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
			return;
		}

		
	}

	List<String> findWords(char[][] board, String[] words) {
		if (words == null || words.length < 1) {
			return new ArrayList<>();
		}

		foundWords = new ArrayList<>(words.length);

		for (int i = 0; i < words.length; ++i) {
			trie.insert(words[i]);
		}

		helper(board, 0, 0);

		return foundWords;
	}

}