package main.java.array;

/**
 * flip m zeros for max consecutive one
 * 
 * @author rdixi7
 *
 */
public class FlipZeroesForMaxConsecutiveOne {
	/**
	 * algo is use sliding window wide window till zero count is less than m as
	 * it reaches to m shrink window from left
	 * 
	 * @param input
	 */
	public static void flipZeroesIndexForMaxOne(int[] input, int m) {
		int lw = 0;
		int rw = 0;
		int leftPointer = 0;
		int zeroCount = 0;
		int maxWindowSize = -1;
		while (rw < input.length) {

			if (zeroCount <= m) {
				if (input[rw] == 0) {
					zeroCount++;
				}
				rw++;
			}

			if (zeroCount > m) {
				if (input[lw] == 0)
					zeroCount--;
				lw++;
			}

			if (rw - lw > maxWindowSize) {
				maxWindowSize = rw - lw;
				leftPointer = lw;
			}
		}
		for (int i = leftPointer; i < (leftPointer + maxWindowSize); i++) {
			if (input[i] == 0)
				System.out.println("0 at index " + i);
		}

	}

	/**
	 * smallest sum that can not be represented as any subset sum of given array
	 * Let the smallest element that cannot be represented by elements at
	 * indexes from 0 to (i-1) be ‘res’, there are following two possibilities
	 * when we consider element at index i:
	 * 
	 * 1) We decide that ‘res’ is the final result: If arr[i] is greater than
	 * ‘res’, then we found the gap which is ‘res’ because the elements after
	 * arr[i] are also going to be greater than ‘res’.
	 * 
	 * 2) The value of ‘res’ is incremented after considering arr[i]: The value
	 * of ‘res’ is incremented by arr[i] (why? If elements from 0 to (i-1) can
	 * represent 1 to ‘res-1′, then elements from 0 to i can represent from 1 to
	 * ‘res + arr[i] – 1′ be adding ‘arr[i]’ to all subsets that represent 1 to
	 * ‘res’)
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	int findSmallest(int arr[], int n) {
		int res = 1; // Initialize result

		// Traverse the array and increment 'res' if arr[i] is
		// smaller than or equal to 'res'.
		for (int i = 0; i < n && arr[i] <= res; i++)
			res = res + arr[i];

		return res;
	}

	public static void main(String[] args) {
		// int arr[] = {0, 0, 0, 1};
		int arr[] = { 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1 };
		int m = 1;
		flipZeroesIndexForMaxOne(arr, m);
	}

}
