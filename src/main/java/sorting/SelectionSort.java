package main.java.sorting;

/**
 * selecting minimum every time and putting it to curent index
 * stable -no but can be implemented as stable
 * in place -yes
 * @author rdixi7
 *
 */
public class SelectionSort {

	private static int[] selectionSort(final int[] input) {
		int length = input.length;
		int min = -1;
		for (int i = 0; i < length - 1; i++) {
			min = i;
			for (int j = i + 1; j < length; j++) {
				if (input[j] < input[min]) {
					min = j;
				}
			}
			int temp = input[i];
			input[i] = input[min];
			input[min] = temp;
		}
		return input;
	}

	public static void main(String[] args) {
		int[] input = { 10, 4, 2, 11, 8, 9 };
		int[] sorted = selectionSort(input);
		for (int i = 0; i < sorted.length; i++)
			System.out.println(sorted[i]);
	}
}
