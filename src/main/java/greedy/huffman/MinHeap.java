package main.java.greedy.huffman;

public class MinHeap {

	private int count;

	private int capacity;

	private HeapNode[] heapNodes;

	public MinHeap(final int capacity) {
		this.capacity = capacity;
		this.heapNodes = new HeapNode[capacity];
		this.count = -1;
	}

	public void minHeapify(final int index) {
		int left = getLeft(index);
		int right = getRight(index);
		int min = index;
		if (left != -1
				&& this.heapNodes[index].getFrequency() > this.heapNodes[left]
						.getFrequency()) {
			min = left;
		}
		if (right != -1
				&& this.heapNodes[right].getFrequency() < this.heapNodes[min]
						.getFrequency()) {
			min = right;
		}
		if (min != index) {
			HeapNode temp = this.heapNodes[index];
			this.heapNodes[index] = this.heapNodes[min];
			this.heapNodes[min] = temp;
			minHeapify(min);
		}
	}

	private int getLeft(final int index) {
		int left = index * 2 + 1;
		if (left > this.count)
			return -1;
		return left;
	}

	private int getRight(final int index) {
		int right = index * 2 + 2;
		if (right > this.count)
			return -1;
		return right;
	}

	public void buildHeap(final char[] chars, final int[] frequency) {
		int length = frequency.length;
		for (int j = 0; j < length; j++) {
			HeapNode newNode = new HeapNode(chars[j], frequency[j]);
			this.heapNodes[j] = newNode;
			this.count++;
		}
		for (int i = (length / 2); i >= 0; i--) {
			minHeapify(i);
		}

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public HeapNode[] getHeapNodes() {
		return heapNodes;
	}

	public void setHeapNodes(HeapNode[] heapNodes) {
		this.heapNodes = heapNodes;
	}

	public HeapNode getHeapNode(final int index) {
		return heapNodes[index];
	}

	public void setHeapNode(final int index, HeapNode heapNode) {
		this.heapNodes[index] = heapNode;
	}

}
