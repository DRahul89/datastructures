package main.java.sorting;

public class HeapSort {

	public static void maxHeapify(int[] input, int length, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		if (left > length || right > length)
			return;
		int largest = -1;
		if (input[left] > input[index]) {
			largest = left;
		} else {
			largest = index;
		}
		if (input[right] > input[largest])
			largest = right;
		if (largest != index) {
			int temp = input[index];
			input[index] = input[largest];
			input[largest] = temp;
			maxHeapify(input, length, largest);
		}

	}

	public static int[] buildMaxHeap(int[] input) {
		for (int i = (input.length / 2); i >= 0; i--) {
			maxHeapify(input, input.length, i);
		}
		return input;
	}

	public static void heapSort(int[] input) {
		for (int i = (input.length)-1; i >= 0; i--) {
			int temp = input[0];
			input[0] = input[i];
			input[i] = temp;
			maxHeapify(input, i-1, 0);
		}
	}

	public static void main(String[] args) {
		int A[] = { 5, 3, 17, 10, 84, 19, 6, 22, 9 };
		buildMaxHeap(A);
		heapSort(A);
		for (int i = 0; i < A.length; i++)
			System.out.println(A[i]);
	}

}
