package main.java.string.ternarysearchtree;

/**
 * A node structure for TST
 */
public class TSTNode {

	private char data;

	private boolean isEnd;

	private TSTNode leftNode;

	private TSTNode equalNode;

	private TSTNode rightNode;

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public TSTNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TSTNode leftNode) {
		this.leftNode = leftNode;
	}

	public TSTNode getEqualNode() {
		return equalNode;
	}

	public void setEqualNode(TSTNode equalNode) {
		this.equalNode = equalNode;
	}

	public TSTNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(TSTNode rightNode) {
		this.rightNode = rightNode;
	}

}
