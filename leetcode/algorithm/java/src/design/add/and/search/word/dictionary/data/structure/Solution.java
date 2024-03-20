package design.add.and.search.word.dictionary.data.structure;

class WordDictionary {

	private class Node {
		boolean terminal = false;
		Node[] nextLetters = new Node[26];

		Node(boolean terminal) {
			this.terminal = terminal;
		}
	}

	Node[] startLetters = new Node[26];

	public WordDictionary() {}

	public void addWord(String word) {
		Node[] currLetters = startLetters;

		for (int i = 0; i < word.length(); ++i) {

			Node node = currLetters[word.charAt(i) - 'a'];

			if (i == word.length() - 1) {
				if (node == null) {
					currLetters[word.charAt(i) - 'a'] = new Node(true);
				}
				else {
					currLetters[word.charAt(i) - 'a'].terminal = true;
				}
				return;
			}

			if (node == null) {
				currLetters[word.charAt(i) - 'a'] = new Node(false);
				node = currLetters[word.charAt(i) - 'a'];
			}

			currLetters = node.nextLetters;
		}
	}

	private boolean testCurrNode(String word, int index, Node currNode) {
		if (currNode == null) {
			return false;
		}

		if (index == word.length() - 1) {
			return currNode.terminal;
		}

		return helper(word, index + 1, currNode.nextLetters);
	}

	private boolean helper(String word, int index, Node[] currentLetters) {
		if (index >= word.length()) {
			return false;
		}

		char currChar = word.charAt(index);
		Node currNode;

		if (currChar != '.') {
			currNode = currentLetters[currChar - 'a'];

			return testCurrNode(word, index, currNode);
		}

		for (int i = 0; i < currentLetters.length; ++i) {
			currNode = currentLetters[i];

			boolean result = testCurrNode(word, index, currNode);

			if (result) {
				return true;
			}
		}

		return false;
	}

	public boolean search(String word) {
		return helper(word, 0, startLetters);
	}
}