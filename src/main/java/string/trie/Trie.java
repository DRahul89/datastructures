package main.java.string.trie;

/**
 * 
 * A class for trie data structure
 *
 */
public class Trie {

	private int count;

	private TrieNode root;

	public Trie() {
		this.count = 0;
		this.root = new TrieNode(' ');
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public TrieNode getRoot() {
		return root;
	}

	public void setRoot(TrieNode root) {
		this.root = root;
	}

	/**
	 * This method insert a text in to trie
	 * 
	 * @param input
	 */
	public void insertNodeInTrie(final String input) {
		int index = 0;
		int level = input.length();
		TrieNode search = this.root;
		TrieNode child = null;
		while (index < level) {
			char inputChar = input.charAt(index++);
			child = search.getChildNode(inputChar);
			if (null != child) {
				search = child;
			} else {
				TrieNode newNode = new TrieNode(inputChar);
				search.getChildren().add(newNode);
				search = newNode;
			}
		}
		search.setEnd(Boolean.TRUE);
	}

	/**
	 * This method search a text in to trie
	 * 
	 * @param input
	 */
	public boolean searchNodeInTrie(final String input) {
		int index = 0;
		int level = input.length();
		TrieNode search = this.root;
		TrieNode child = null;
		while (index < level) {
			char inputChar = input.charAt(index++);
			child = search.getChildNode(inputChar);
			if (null == child) {
				return false;
			} else {
				search = child;
			}
		}
		return search.isEnd();
	}

	/**
	 * This method search a max pefix of a string which is also a word in trie
	 * 
	 * @param input
	 */
	public String searchMaxPrefixStringInTrie(final String input) {
		int index = 0;
		String result = "";
		int matchedIndex = 0;
		int level = input.length();
		TrieNode search = this.root;
		TrieNode child = null;
		while (index < level) {
			char inputChar = input.charAt(index);
			child = search.getChildNode(inputChar);
			if (null == child) {
				break;
			} else if (child.isEnd()) {
				matchedIndex = index + 1;
				result += inputChar;
			} else {
				result += inputChar;
			}
			search = child;
			index++;
		}
		return  result.substring(0, matchedIndex);
	}
}
