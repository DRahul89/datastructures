package main.java.tree.avl;

public class AVLNode {

	private int data;

	private AVLNode leftNode;
	private AVLNode rightNode;

	private int height;

	public AVLNode(final int key) {
		this.data = key;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public AVLNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(AVLNode leftNode) {
		this.leftNode = leftNode;
	}

	public AVLNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(AVLNode rightNode) {
		this.rightNode = rightNode;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
