package main.java.array;

/**
 * we calculate the next rotation from previous rotation and derive this formula
 * Rj - Rj-1 = arrSum - n * arr[n-j]
 * 
 * max i*arr(i)
 * 
 * @author rdixi7
 *
 */
public class ArrayRotationQuestion {

	/**
	 * 1) Compute sum of all array elements. Let this sum be 'arrSum'.
	 * 
	 * 2) Compute R0 by doing i*arr[i] for given array. Let this value be
	 * currVal.
	 * 
	 * 3) Initialize result: maxVal = currVal // maxVal is result.
	 * 
	 * // This loop computes Rj from Rj-1 4) Do following for j = 1 to n-1
	 * ......a) currVal = currVal + arrSum-n*arr[n-j]; ......b) If (currVal >
	 * maxVal) maxVal = currVal
	 * 
	 * 5) Return maxVal
	 * 
	 * @return
	 */
	public static int maxSum(int[] input) {
		int n = input.length;
		int arrSum = 0;
		int maxSum = -1;
		int currSum = 0;
		for (int i = 0; i < n; i++) {
			arrSum = arrSum + input[i];
			currSum = currSum+ i * input[i];
		}
		maxSum = currSum;
		for (int j = 1; j < n; j++) {
			currSum = currSum + arrSum - n * input[n - j];
			if (currSum > maxSum)
				maxSum = currSum;
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(maxSum(arr));
	}
}
