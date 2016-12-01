package main.java.greedy.huffman;

/**
 * 
 *PRIORITY QUEUE BY MIN HEAP 
 *
 */
public class PriorityQueueByMinHeap {

	private MinHeap minHeap;

	public PriorityQueueByMinHeap(final MinHeap minHeap) {
		this.minHeap = minHeap;
	}

	private void decreaseKey(final int index, final HeapNode heapNode) {
		minHeap.setHeapNode(index, heapNode);
		int i = index;
		while (i > 0
				&& minHeap.getHeapNodes()[i].getFrequency() < minHeap
						.getHeapNodes()[(i - 1) / 2].getFrequency()) {
			HeapNode temp = minHeap.getHeapNodes()[i];
			minHeap.setHeapNode(i, minHeap.getHeapNodes()[(i - 1) / 2]);
			minHeap.setHeapNode((i - 1) / 2, temp);
			i = (i - 1) / 2;
		}
	}

	public void insertKey(final HeapNode heapNode) {
		minHeap.setCount(minHeap.getCount() + 1);
		decreaseKey(minHeap.getCount(), heapNode);
	}

	public HeapNode extractMin() {
		HeapNode heapNode = minHeap.getHeapNodes()[0];
		minHeap.setHeapNode(0, minHeap.getHeapNode(minHeap.getCount()));
		minHeap.setCount(minHeap.getCount() - 1);
		minHeap.minHeapify(0);
		return heapNode;
	}

	public int getSize() {
		return minHeap.getCount();
	}

}
