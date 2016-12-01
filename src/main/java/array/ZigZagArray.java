package main.java.array;

/**
 * a<b>c<d>e one approach sort and except first swap others O(n log n) second is
 * one pass of bubble sort and use flag to perform logic
 * 
 * @author rdixi7
 *
 */
public class ZigZagArray {

	/**
	 * one pass bubble sort
	 * 
	 * @param input
	 * @param flag
	 *            true means < expected false means >
	 */
	public static void zigZagPattern(int[] input, boolean flag) {
		for (int i = 0; i < input.length - 1; i++) {
			if (flag) {
				if (input[i] > input[i + 1]) {
					int temp = input[i];
					input[i] = input[i + 1];
					input[i + 1] = temp;
				}
			} else {
				if (input[i] < input[i + 1]) {
					int temp = input[i];
					input[i] = input[i + 1];
					input[i + 1] = temp;
				}
			}
			flag = !flag;
		}

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = { 4, 3, 7, 8, 6, 2, 1 };
		zigZagPattern(arr, Boolean.TRUE);
	}
}
