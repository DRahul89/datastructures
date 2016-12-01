package main.java.array;

import java.util.Arrays;

/**
 * algo naive in order pow(n,3) second algo is sort the array a loop for all
 * elements it would work as every first element of triplet
 * 
 * @author rdixi7
 *
 */
public class TripletsWithSumLessThanGivenValue {
	/**
	 * 
	 * @param input
	 * @param sum
	 */
	public static int printTripletWithLessGivenSum(int[] input, int n, int sum) {
		int result = 0;
		Arrays.sort(input);
		for (int i = 0; i < n - 2; i++) {
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				if (input[i] + input[j] + input[k] >= sum)
					k--;
				else {
					result = result + (k - j);
					j++;
				}

			}
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 5, 1, 3, 4, 7 };
		System.out.println(printTripletWithLessGivenSum(arr, arr.length, 12));
	}

}
