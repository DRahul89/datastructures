package main.java.sorting;

/**
 * for any element arr[i] pick and fit it to arr[0 to i-1],we can use binary
 * search for second phase of insertion sort but it would not change the worst
 * case run time as swap required would be there
 * in place - yes
 * stable -yes
 * @author rdixi7
 *
 */
public class InsertionSort {

	private static int[] insertionSort(final int[] input) {
		int j = -1;
		int element = -1;
		for (int i = 1; i < input.length; i++) {
			j = i;
			element = input[i];
			while (j >= 1 && input[j - 1] > element) {
				input[j] = input[j - 1];
				j--;
			}
			input[j] = element;
		}
		return input;
	}

	public static void main(String[] args) {
		int[] input = { 15, 10, 4, 2, 11, 8, 9, 5 };
		int[] sorted = insertionSort(input);
		for (int i = 0; i < sorted.length; i++)
			System.out.println(sorted[i]);
	}
}
