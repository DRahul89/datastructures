package main.java.heap;

/**
 * Implementation of priority queue data structure
 *
 *
 */
public class PriorityQueueByMaxHeap {

	private Heap heap;

	public PriorityQueueByMaxHeap(final Heap heap) {
		this.heap = heap;
	}

	public void increaseKey(final int index, final int newVal) {
		heap.getHeapArray()[index] = newVal;
		int i = index;
		while (i > 0
				&& heap.getHeapArray()[i] > heap.getHeapArray()[(i - 1) / 2]) {
			int temp = heap.getHeapArray()[i];
			heap.getHeapArray()[i] = heap.getHeapArray()[(i - 1) / 2];
			heap.getHeapArray()[(i - 1) / 2] = temp;
			i = (i - 1) / 2;
		}
	}

	public void insertKey(final int val) {
		heap.setCount(heap.getCount() + 1);
		increaseKey(heap.getCount(), val);
	}

	public int extractMaxKey() {
		int max = heap.getHeapArray()[0];
		heap.getHeapArray()[0] = heap.getHeapArray()[heap.getCount() - 1];
		heap.setCount(heap.getCount() - 1);
		heap.maxHeapify(0);
		return max;
	}
}
