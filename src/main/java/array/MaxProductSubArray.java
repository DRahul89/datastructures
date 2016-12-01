package main.java.array;

public class MaxProductSubArray {

	public static int maxProductSubArray(int[] input) {
		int maxSoFar = -1;
		// it would be either 1 or positive
		int maxEndingHere = 1;
		// either 1 or negative
		int minEndingHere = 1;
		for (int i = 0; i < input.length; i++) {
			// if minending is negative then multiply with current else make it
			// 1
			if (input[i] > 0) {
				maxEndingHere = maxEndingHere * input[i];
				minEndingHere = Math.min(minEndingHere * input[i], 1);
			}

			else if (input[i] == 0) {
				maxEndingHere = 1;
				minEndingHere = 1;
			}
			// now minEndingHere would either 1 or negative so it would be
			// maxEndingHere * input[i]
			// similarly maxEndingHere would either positive or 1 so it would be
			// minEndinghere*input[i]
			else {
				int temp = maxEndingHere;
				maxEndingHere = Math.max(minEndingHere * input[i], 1);
				minEndingHere = temp * input[i];

			}

			if (maxEndingHere > maxSoFar)
				maxSoFar = maxEndingHere;

		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
		System.out.println(maxProductSubArray(arr));
	}

}
