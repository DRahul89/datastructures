package main.java.tree.bst;

public class BSTNode {
	int key;
	BSTNode left;
	BSTNode right;

	public BSTNode(int item) {
		this.key = item;
		this.left = this.right = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "BSTNode [key=" + key + ", left=" + left + ", right=" + right + "]";
	}
	
	
}
