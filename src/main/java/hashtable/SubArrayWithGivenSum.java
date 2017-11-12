package main.java.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * algo is do the sum of all element and hash each sum now for each point sum -
 * given sum is already seen then subarray exists
 * 
 * @author rdixi3
 *
 */
public class SubArrayWithGivenSum {

	public static void subArrayExists(int[] elem, int sum) {
		int indexSum = 0;
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < elem.length; i++) {
			indexSum = indexSum + elem[i];
			if (indexSum == sum) {
				System.out.println("subarray exists from index 0 to index " + i);
			}
			if (null == indexMap.get(indexSum - sum)) {
				indexMap.put(indexSum, i);
			} else {
				System.out
						.println("subarray exists from index " + (indexMap.get(indexSum - sum) + 1) + " to index " + i);
			}
		}
	}

	public static int largestSubArrayWithZeroSum(int[] elem) {
		int indexSum = 0;
		int maxlen = 0;
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < elem.length; i++) {
			indexSum = indexSum + elem[i];
			if (indexSum == 0) {
				maxlen = i + 1;
			}
			if (null == indexMap.get(indexSum)) {
				indexMap.put(indexSum, i);
			} else {
				maxlen = Math.max(maxlen, i - indexMap.get(indexSum));
			}
		}
		return maxlen;
	}

	public static int allSubArrayWithZeroSum(int[] elem) {
		int indexSum = 0;
		int maxlen = 0;
		Map<Integer, List<Integer>> indexMap = new HashMap<>();
		for (int i = 0; i < elem.length; i++) {
			indexSum = indexSum + elem[i];
			if (indexSum == 0) {
				System.out.println("zero subarray exists from index 0 to index " + i);
				indexMap.put(indexSum, new ArrayList<>(i));
			}
			if (null != indexMap.get(indexSum)) {
				List<Integer> allIndexes = indexMap.get(indexSum);
				for (Integer index : allIndexes) {
					System.out.println("zero subarray exists from index " + (index + 1) + " to index " + i);
				}
				allIndexes.add(i);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				indexMap.put(indexSum, list);
			}
		}
		return maxlen;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 2, -2, -20, 10 };
		int sum = -10;
		// subArrayExists(arr, sum);
		int arr2[] = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		// System.out.println("largest zero sub
		// sequence:"+largestSubArrayWithZeroSum(arr));
		allSubArrayWithZeroSum(arr2);
	}
}
