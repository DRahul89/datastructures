package main.java.sorting;

/**
 * print k smallest elemenmt of an array by median algo same as qick sort
 * 
 * @author rdixi7
 *
 */
public class SelectionAlgo {

	public static int partition(int[] input, int low, int high) {
		int pivot = input[high];
		int index = low - 1;
		for (int i = low; i <= high; i++) {
			if (input[i] < pivot) {
				index++;
				int temp = input[i];
				input[i] = input[index];
				input[index] = temp;
			}
		}
		int temp = input[high];
		input[high] = input[++index];
		input[index] = temp;
		return index;

	}

	public static void selection(int[] input, int low, int high, int k) {

		if (low == high) {
			for (int i = 0; i <= low; i++)
			System.out.print(input[i] + " ");
		} else {
			int part = partition(input, low, high);
			int count = part - low + 1;
			if (count == k) {
				for (int i = 0; i < (low+count); i++)
					System.out.print(input[i] + " ");
			} else if (count > k) {
				selection(input, low, part-1, k);
			} else {
				selection(input, part + 1, high, k - count);
			}
		}

	}
	
	public static void main(String[] args) {
		int[] input = { 10, 4, 2, 15, 11, 8, 9 };
		selection(input, 0, input.length-1, 0);
	}

}
