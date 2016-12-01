package main.java.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * this can be use as find all subarrays with given sum
 * 
 * @author rdixi7
 *
 */
public class PrintAllSubArrayWithZeroSum {

	public static void printSubArrayWithZeroSum(int[] input) {

		Map<Integer, List<Integer>> zeroSumIndices = new HashMap<>();
		Integer sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum = sum + input[i];
			if (sum == 0) {
				System.out.println("Zero sum between indices 0 and " + i);
			}
			List<Integer> val = zeroSumIndices.get(sum);
			if (null != val) {
				for (Integer in : val) {
					System.out.println("Zero sum between indices " + in.intValue() + " and " + i);
				}
				val.add(i + 1);
				zeroSumIndices.put(sum, val);
			} else {
				List<Integer> indices = new ArrayList<>();
				indices.add(i + 1);
				zeroSumIndices.put(sum, indices);
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		printSubArrayWithZeroSum(arr);
	}

}
