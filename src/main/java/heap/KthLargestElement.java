package main.java.heap;

/**
 * algo take min heap build min heap fom first k elemnt then compare rest k to
 * n-k with root if greater remove root insert element and heapify thats way at
 * the end there would be only k largest elkemnts
 * 
 * 
 *
 */
public class KthLargestElement {

	public static void klargest(int[] elemnts, int k) {
		int[] arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = elemnts[i];
		}
		Heap h = new Heap(k);
		h.buildMinHeap(arr);
		for (int j = k; j < elemnts.length; j++) {
			int nextElm = elemnts[j];
			if (h.getHeapArray()[0] < nextElm) {
				h.getHeapArray()[0] = nextElm;
				h.minHeapify(0);
			}
		}
		for (int i = 0; i < k; i++) {
			System.out.print(h.getHeapArray()[i] + " ");
		}
		
	}
	
	public static void kSmallest(int[] elemnts, int k) {
		int[] arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = elemnts[i];
		}
		Heap h = new Heap(k);
		h.buildMaxHeap(arr);
		for (int j = k; j < elemnts.length; j++) {
			int nextElm = elemnts[j];
			if (h.getHeapArray()[0] > nextElm) {
				h.getHeapArray()[0] = nextElm;
				h.maxHeapify(0);
			}
		}
		for (int i = 0; i < k; i++) {
			System.out.print(h.getHeapArray()[i] + " ");
		}
		
	}
	
	public static void main(String[] args) {
		int arr[]={1, 23, 12, 9, 30, 2, 50};
		klargest(arr, 2);
		System.out.println("");
		kSmallest(arr, 2);
	}
}
