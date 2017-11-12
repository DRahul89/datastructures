package main.java.heap;

/**
 * elements are not more than k distance from there original positions algo
 * 
 * create a minheap from k+1 elements now extract min put in result array and
 * add a new from array and repeat think zero index or min value must lie from 0
 * to k+1 similarly 1 index or min must lie from 1 to k+2
 *
 */
public class SortKSortedArray {

	
	public static void sortNearlySorted(int [] elemnts,int k){
		int[] arr = new int[k+1];
		int[] result = new int[elemnts.length];
		for (int i = 0; i < k+1; i++) {
			arr[i] = elemnts[i];
		}
		Heap h = new Heap(k+1);
		h.buildMinHeap(arr);
		for (int j = k+1,i=0; i < elemnts.length; j++,i++) {
				if(j<elemnts.length){
				result[i]=h.getHeapArray()[0];
				h.getHeapArray()[0] = elemnts[j];
				h.minHeapify(0);
				}else{
					result[i]=h.extractMinKey();
				}
		}
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
	}
	
	public static void main(String[] args) {

	    int k = 3;
	    int arr[] = {2, 6, 3, 12, 56, 8};
	    sortNearlySorted(arr,k);
	}
}
