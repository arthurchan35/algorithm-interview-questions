package implement.trie;

class Trie {

	private class Node {
		boolean terminal = false;
		Node[] nextLetters = new Node[26];

		Node(boolean terminal) {
			this.terminal = terminal;
		}
	}

	Node[] startLetters = new Node[26];

	public Trie() {}

	public void insert(String word) {
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

	public boolean search(String word) {
		Node[] currLetters = startLetters;

		for (int i = 0; i < word.length(); ++i) {
			Node node = currLetters[word.charAt(i) - 'a'];

			if (node == null) {
				return false;
			}

			if (i == word.length() - 1) {
				return node.terminal;
			}

			currLetters = node.nextLetters;
		}

		return false;
	}

	public boolean startsWith(String prefix) {
		Node[] currLetters = startLetters;

		for (int i = 0; i < prefix.length(); ++i) {
			Node node = currLetters[prefix.charAt(i) - 'a'];

			if (node == null) {
				return false;
			}

			currLetters = node.nextLetters;
		}

		return true;
	}
}