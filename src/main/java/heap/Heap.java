package main.java.heap;

/**
 * 
 * Heap data structure implementation
 *
 */
public class Heap {

	private int count;

	private int[] heapArray;

	private int capacity;

	public Heap(final int capacity) {
		this.count = capacity - 1;
		this.capacity = capacity;
		heapArray = new int[capacity];
	}

	public Heap() {
	}

	public void maxHeapify(final int index) {
		int left = getLeft(index);
		int right = getRight(index);
		if (left == -1 || right == -1)
			return;
		int max = -1;
		if (this.heapArray[index] > this.heapArray[left]) {
			max = index;
		} else {
			max = left;
		}
		if (this.heapArray[right] > this.heapArray[max])
			max = right;
		if (max != index) {
			int temp = this.heapArray[index];
			this.heapArray[index] = this.heapArray[max];
			this.heapArray[max] = temp;
			maxHeapify(max);
		}
	}

	public void minHeapify(final int index) {
		int left = getLeft(index);
		int right = getRight(index);
		if (left == -1 || right == -1)
			return;
		int min = -1;
		if (this.heapArray[index] < this.heapArray[left]) {
			min = index;
		} else {
			min = left;
		}
		if (this.heapArray[right] < this.heapArray[min])
			min = right;
		if (min != index) {
			int temp = this.heapArray[index];
			this.heapArray[index] = this.heapArray[min];
			this.heapArray[min] = temp;
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

	public void buildHeap(final int[] input) {
		int length = input.length;
		for (int j = 0; j < length; j++) {
			this.heapArray[j] = input[j];
		}
		for (int i = (length / 2); i >= 0; i--) {
			maxHeapify(i);
		}

	}

	public void heapSort(int[] input) {
		buildHeap(input);
		for (int i = (input.length) - 1; i >= 0; i--) {
			int temp = this.heapArray[0];
			this.heapArray[0] = this.heapArray[i];
			this.heapArray[i] = temp;
			this.count--;
			maxHeapify(0);
		}
	}

	public static void main(String[] args) {

		int input[] = { 5, 3, 17, 10, 84, 19, 6, 22, 9 };
		Heap h = new Heap(input.length);
		h.heapSort(input);
		for (int i = 0; i < input.length; i++)
			System.out.println(h.heapArray[i]);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int[] getHeapArray() {
		return heapArray;
	}

	public void setHeapArray(int[] heapArray) {
		this.heapArray = heapArray;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
