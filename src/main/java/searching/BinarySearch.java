package main.java.searching;

public class BinarySearch {

	private static int binarySearchIterative(final int[] input, final int data) {
		int low = 0;
		int high = input.length;
		int searchedIndex = -1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (input[mid] == data) {
				searchedIndex = mid;
				break;
			} else if (input[mid] > data) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		return searchedIndex;
	}

	private static int binarySearchrecursive(int[] input, int low, int high,
			int data) {
		if (low > high)
			return -1;
		int mid = low + (high - low) / 2;
		if (input[mid] == data) {
			return mid;
		} else if (input[mid] > data) {
			return binarySearchrecursive(input, low, mid - 1, data);
		} else {
			return binarySearchrecursive(input, mid + 1, high, data);
		}

	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5 };
		System.out.println(binarySearchIterative(input, 10));
		System.out.println(binarySearchrecursive(input, 0, 4, 10));

	}

}
