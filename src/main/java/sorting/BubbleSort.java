package main.java.sorting;

/**
 * each iteration send the largest of remaining to end like bubbles in glass
 * in place - true
 * stable -true
 * @author rdixi7
 *
 */
public class BubbleSort {

	public static int[] sort(final int[] input) {
		int length = input.length;
		boolean swapped = true;
		for (int i = length - 1; i >= 0 && swapped; i--) {
			for (int j = 0; j <= i - 1; j++) {
				swapped = false;
				if (input[j] > input[j + 1]) {
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
					swapped = true;
				}
			}
		}
		return input;
	}

	public static int[] sortSecond(final int[] input) {
		int length = input.length;
		boolean swapped = true;
		for (int i = 1; i < length; i++) {
			for (int j = length - 1; j > i - 1; j--) {
				// swapped = false;
				if (input[j] < input[j - 1]) {
					int temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;
					// swapped = true;
				}
			}
		}
		return input;
	}

	public static void main(String[] args) {
		int[] input = { 10, 4, 2, 11, 8, 9 };
		int[] sorted = sortSecond(input);
		int[] sorted2 = sort(input);
		for (int i = 0; i < sorted.length; i++)
			System.out.println(sorted2[i]);
	}
}
