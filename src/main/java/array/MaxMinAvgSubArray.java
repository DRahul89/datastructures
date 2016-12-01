package main.java.array;

/**
 * similarly for minimum
 * 
 * @author rdixi7
 *
 */
public class MaxMinAvgSubArray {

	public static void maxAvgSubarray(int[] input, int k) {
		int avgSubSum = 0;
		int maxSum = 0;
		int subIndex = 0;
		for (int i = 0; i < k; i++)
			avgSubSum = input[i];

		for (int i = k; i < input.length; i++) {
			avgSubSum = avgSubSum + input[k] - input[i - k];
			if (avgSubSum > maxSum) {
				maxSum = avgSubSum;
				subIndex = i;
			}
		}

		System.out.println("max avg sub array found at " + (subIndex - k) + " to " + subIndex);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 12, -5, -6, 50, 3 };
		maxAvgSubarray(arr, 4);
	}

}
