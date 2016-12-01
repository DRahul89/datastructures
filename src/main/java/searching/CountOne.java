package main.java.searching;

/**
 * count number of 1 in sorted binary array idea is use binary search if array
 * is this 1 1 0 0 0 output 2
 * 
 * @author rdixi7
 *
 */
public class CountOne {

	public static int searchLastOne(int[] input, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (input[mid] == 1 && input[mid + 1] == 0)
				return mid+1;

			if (input[mid] == 1)
				return searchLastOne(input, mid + 1, high);
			else
				return searchLastOne(input, low, mid - 1);
		}

		return 0;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 1, 1, 0, 0, 0, 0};
		System.out.println(searchLastOne(arr, 0, arr.length));
	}

}
