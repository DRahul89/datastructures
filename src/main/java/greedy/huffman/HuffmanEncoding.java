package main.java.greedy.huffman;

/**
 * 
 *
 */
public class HuffmanEncoding {
	/**
	 * A function which will built huffman tree from data using min heap
	 * 
	 * @param data
	 * @param frequency
	 * @return
	 */
	public static HeapNode buildHuffmanTree(final char[] data, final int[] frequency) {
		MinHeap minHeap = new MinHeap(frequency.length);
		minHeap.buildHeap(data, frequency);
		PriorityQueueByMinHeap priorityQueueByMinHeap = new PriorityQueueByMinHeap(minHeap);
		while (priorityQueueByMinHeap.getSize() >= 1) {
			HeapNode firstMin = priorityQueueByMinHeap.extractMin();
			HeapNode secondMin = priorityQueueByMinHeap.extractMin();
			HeapNode newNode = new HeapNode('$', firstMin.getFrequency() + secondMin.getFrequency());
			newNode.setLeftNode(firstMin);
			newNode.setRightNode(secondMin);
			priorityQueueByMinHeap.insertKey(newNode);
		}
		return priorityQueueByMinHeap.extractMin();
	}

	/**
	 * print huffman tree
	 * 
	 * @param heapNode
	 * @param codes
	 * @param top
	 */
	public static void printHuffman(final HeapNode heapNode, final int[] codes, int top) {
		if (heapNode.getLeftNode() != null) {
			codes[top] = 0;
			printHuffman(heapNode.getLeftNode(), codes, top + 1);
		}
		if (heapNode.getRightNode() != null) {
			codes[top] = 1;
			printHuffman(heapNode.getRightNode(), codes, top + 1);
		}

		if (heapNode.getLeftNode() == null && heapNode.getRightNode() == null) {
			System.out.print("Data :" + heapNode.getData() + " ");
			for (int i = 0; i < top; i++)
				System.out.print(codes[i]);
			System.out.println();

		}
	}

	/**
	 * print huffman tree
	 * 
	 * @param heapNode
	 * @param codes
	 * @param top
	 */
	public static void printHuffmanSecond(final HeapNode heapNode, final int[] codes, int top, int val) {
		if (top >= 0)
			codes[top] = val;
		if (heapNode.getLeftNode() == null && heapNode.getRightNode() == null) {
			System.out.print("Data :" + heapNode.getData() + " ");
			for (int i = 0; i <= top; i++)
				System.out.print(codes[i]);
			System.out.println();

		}
		if (heapNode.getLeftNode() != null) {
			printHuffmanSecond(heapNode.getLeftNode(), codes, top + 1, 0);
		}
		if (heapNode.getRightNode() != null) {
			printHuffmanSecond(heapNode.getRightNode(), codes, top + 1, 1);
		}

	}

	public static void main(String[] args) {
		char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int freq[] = { 5, 9, 12, 13, 16, 45 };
		int[] codes = new int[6];
		 //printHuffman(buildHuffmanTree(arr, freq), codes, 0);
		printHuffmanSecond(buildHuffmanTree(arr, freq), codes, -1, -1);
	}
}
