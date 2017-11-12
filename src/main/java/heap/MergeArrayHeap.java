package main.java.heap;

class HeapNode {
	int data;
	int rowIndex;
	int nextElementIndex;
}

public class MergeArrayHeap {

	private HeapNode[] nodes;
	private int count;
	private int capacity;

	public MergeArrayHeap(int capacity) {
		this.capacity = capacity;
		this.count = capacity - 1;
		this.nodes = new HeapNode[capacity];

	}

	public void minHeapify(final int index) {
		int left = getLeft(index);
		int right = getRight(index);
		if (left == -1 && right == -1)
			return;
		int min = -1;
		if (left != -1 && this.nodes[index].data < this.nodes[left].data) {
			min = index;
		} else {
			min = left;
		}
		if (right != -1 && this.nodes[right].data < this.nodes[min].data)
			min = right;
		if (min != index) {
			HeapNode temp = this.nodes[index];
			this.nodes[index] = this.nodes[min];
			this.nodes[min] = temp;
			minHeapify(min);
		}
	}

	public int extractMinKey() {
		int min = this.getNodes()[0].data;
		if (this.getCount() > 0) {
			this.getNodes()[0].data = this.getNodes()[this.getCount()].data;
			this.setCount(this.getCount() - 1);
			this.minHeapify(0);
		}
		return min;
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
	
	public void buildMinHeap(final HeapNode[] input) {
		int length = input.length;
		for (int j = 0; j < length; j++) {
			this.nodes[j] = input[j];
		}
		for (int i = (length / 2); i >= 0; i--) {
			minHeapify(i);
		}

	}
	public void replaceMin(HeapNode x){
		this.nodes[0] =x;
		this.minHeapify(0);
	}
	public HeapNode[] getNodes() {
		return nodes;
	}

	public void setNodes(HeapNode[] nodes) {
		this.nodes = nodes;
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

}
