package main.java.sorting;
/**
 * in place - no
 * stable - yes
 * usefull for linked list over quick sort
 * @author rdixi7
 *
 */
public class MergeSort {

	private static void mergeSortFunc(final int[] input, final int[] temp,
			final int left, final int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSortFunc(input, temp, left, mid);
			mergeSortFunc(input, temp, mid + 1, right);
			merge(input, temp, left, mid, right);
		}
	}

	private static void merge(int[] input, int[] temp, int left, int mid,
			int right) {
		int rightPointer = mid + 1;
		int size = right - left + 1;
		int tempPost = left;
		while ((left <= mid) && (rightPointer <= right)) {
			if (input[left] < input[rightPointer]) {
				temp[tempPost] = input[left];
				tempPost++;
				left++;
			} else {
				temp[tempPost] = input[rightPointer];
				tempPost++;
				rightPointer++;
			}
		}
		while (left <= mid) {
			temp[tempPost] = input[left];
			tempPost++;
			left++;
		}
		while (rightPointer <= right) {
			temp[tempPost] = input[rightPointer];
			tempPost++;
			rightPointer++;
		}
		for (int i = 0; i < size; i++) {
			input[right] = temp[right];
			right--;
		}
	}

	public static void main(String[] args) {
		int[] input = { 10, 4, 2,15,11, 8, 9 };
		int[] temp = new int[input.length];
		mergeSortFunc(input, temp, 0, 6);
		for (int i = 0; i < input.length; i++)
			System.out.println(input[i]);
	}
}
