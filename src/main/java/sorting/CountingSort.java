package main.java.sorting;

public class CountingSort {

	public static int[] countSort(final int[] input, final int range) {
		int[] rangeArray = new int[range];
		int[] temp = new int[input.length];
		for (int i = 0; i < range; i++) {
			rangeArray[i] = 0;
		}
		for (int i = 0; i < input.length; i++) {
			rangeArray[input[i]] = rangeArray[input[i]] + 1;
		}

		for (int i = 1; i < range; i++) {
			rangeArray[i] = rangeArray[i] + rangeArray[i - 1];
		}

		for (int i = 0; i < input.length; i++) {
			temp[rangeArray[input[i]]-1] = input[i];
			rangeArray[input[i]] = rangeArray[input[i]] - 1;
		}

		return temp;

	}

	public static void main(String[] args) {
		int[] input = { 10, 4, 2, 11, 8, 9 ,15};
		int[] sorted = countSort(input, 16);
		for (int i = 0; i < sorted.length; i++)
			System.out.println(sorted[i]);
	}

}
