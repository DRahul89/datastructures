package main.java.tree.bst;

public class BSTNode {
	int key;
	BSTNode left;
	BSTNode right;

	public BSTNode(int item) {
		this.key = item;
		this.left = this.right = null;
	}
}
