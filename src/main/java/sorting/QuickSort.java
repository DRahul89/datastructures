package main.java.sorting;

/**
 * iterative quick sort by using stack 3 way quick sort for redunt type of
 * element sorting only difference it maintains 3 things for pivot first less to
 * pivot second equal to pivot third greater than pivot
 * 
 * @author rdixi7
 *
 */
public class QuickSort {

	public static int partition(int[] input, int low, int high) {
		int pivot = input[high];
		int index = low - 1;
		for (int i = low; i < high; i++) {
			if (input[i] <= pivot) {
				index++;
				// swap index and i
				int temp = input[i];
				input[i] = input[index];
				input[index] = temp;
			}
		}
		// swap index+1 and pivot
		int temp = input[index + 1];
		input[index + 1] = input[high];
		input[high] = temp;

		return index + 1;

	}

	public static void quickSort(final int[] arr, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(arr, low, high);
			quickSort(arr, low, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, high);
		}

	}

	public static void main(String[] args) {
		int[] input = { 10, 4, 2, 15, 11, 8, 9 };
		quickSort(input, 0, 6);
		for (int i = 0; i < input.length; i++)
			System.out.print(input[i] + " ");
	}

}
