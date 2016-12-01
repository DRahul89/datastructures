package main.java.greedy.huffman;

public class HeapNode {

	private char data;

	private int frequency;

	private HeapNode leftNode;

	private HeapNode rightNode;

	public HeapNode(final char data, final int frequency) {
		this.data = data;
		this.frequency = frequency;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public HeapNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(HeapNode leftNode) {
		this.leftNode = leftNode;
	}

	public HeapNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(HeapNode rightNode) {
		this.rightNode = rightNode;
	}

}
