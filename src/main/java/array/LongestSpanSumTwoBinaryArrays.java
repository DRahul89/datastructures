package main.java.array;

import java.util.Arrays;

/**
 * algo is max sum can be n for both arrays so their difference can vary from -
 * n to + n so take an array of 2n+1 size and maintain index for differences in
 * this array now for same sum compute max span
 * 
 * @author rdixi7
 *
 */
public class LongestSpanSumTwoBinaryArrays {

	public static int longestSpanOfSameSum(int[] first, int[] second, int n) {
		int maxLen = 0;
		int[] indexArr = new int[2 * n + 1];
		Arrays.fill(indexArr, -1);
		int preSum1 = 0;
		int preSum2 = 0;
		for (int i = 0; i < n; i++) {
			preSum1 = preSum1 + first[i];
			preSum2 = preSum2 + second[i];
			int diff = preSum1 - preSum2;
			int index = n + diff;
			if (diff == 0) {
				maxLen = i + 1;
			} else if (indexArr[index] == -1) {
				indexArr[index] = i;
			} else {
				int len = i - indexArr[index];
				if (len > maxLen)
					maxLen = len;

			}

		}
		return maxLen;
	}

	public static void main(String[] args) {
		int arr1[] = { 0, 1, 0, 1, 1, 1, 1 };
		int arr2[] = { 1, 1, 1, 1, 1, 0, 1 };
		System.out.println(longestSpanOfSameSum(arr1, arr2, arr1.length));
	}

}
