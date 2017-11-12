package main.java.heap;

/**
 * algo creates a min heap from first element of all arrays now extract min from
 * heap put on output array now take the element from the same array from where
 * min found replace with min and hepify repeat this
 * 
 * @author rdixi3
 *
 */
public class MergeKSortedArrays {

	public static void mergeArrays(int[][] arrays, int k, int n) {
		int[] output = new int[n * k];
		HeapNode[] heapNodes = new HeapNode[k];
		for (int i = 0; i < k; i++) {
			HeapNode node = new HeapNode();
			node.data = arrays[i][0];
			node.rowIndex = i;
			node.nextElementIndex = 1;
			heapNodes[i]=node;

		}
		MergeArrayHeap mr = new MergeArrayHeap(k);
		mr.buildMinHeap(heapNodes);
		for (int i = 0; i < n * k; i++) {
			output[i] = mr.getNodes()[0].data;
			if (mr.getNodes()[0].nextElementIndex < n) {
				mr.getNodes()[0].data = arrays[mr.getNodes()[0].rowIndex][mr.getNodes()[0].nextElementIndex];
				mr.getNodes()[0].nextElementIndex++;

			} else {
				mr.getNodes()[0].data = Integer.MAX_VALUE;
			}
			mr.minHeapify(0);
		}
		for (int i = 0; i < n * k; i++) {
			System.out.print(output[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		 int [][] arr =  {{2, 6, 12, 34},
                 {1, 9, 20, 1000},
                 {23, 34, 90, 2000}};
		 
		 mergeArrays(arr, 3, 4);
	}
}
