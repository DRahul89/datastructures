package main.java.string.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Node structure for trie
 *
 */
public class TrieNode {

	private char value;

	private List<TrieNode> children;

	private boolean isEnd;

	public TrieNode(char value) {
		this.value = value;
		this.children = new ArrayList<TrieNode>();
		this.isEnd = false;

	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public List<TrieNode> getChildren() {
		return children;
	}

	public void setChildren(List<TrieNode> children) {
		this.children = children;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public TrieNode getChildNode(final char input) {
		TrieNode searchNode = null;
		for (TrieNode trieNode : this.children) {
			if (trieNode.getValue() == input)
				searchNode = trieNode;
		}
		return searchNode;
	}

	@Override
	public String toString() {
		return "TrieNode [value=" + value + ", children=" + children
				+ ", isEnd=" + isEnd + "]";
	}
	

}
