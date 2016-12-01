package main.java.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * use binary searh to add sub arrays with same digit in O(logn)
 * 
 * @author rdixi7
 *
 */
public class PrintFrequencyInArray {

	public static void findFrequency(int[] input, int low, int high, Map<Integer, Integer> freq) {
		if (input[low] == input[high]) {
			int oldVal = freq.get(input[low]) != null ? freq.get(input[low]) : 0;
			freq.put(input[low], oldVal + (high - low + 1));
		} else {
			int mid = low + (high - low) / 2;
			findFrequency(input, low, mid, freq);
			findFrequency(input, mid + 1, high, freq);
		}
	}

	public static void printFrequency(int[] input) {
		Map<Integer, Integer> freq = new HashMap<>();
		findFrequency(input, 0, input.length - 1, freq);
		Set<Integer> keySet = freq.keySet();
		Iterator<Integer> iter = keySet.iterator();
		while (iter.hasNext()) {
			int key = iter.next();
			System.out.println(" key " + key + " frequency " + freq.get(key));
		}
	}

	/**
	 * algo is subtract 1 to all elements and then use modulo and devide
	 * operator
	 * 
	 * @param input
	 */
	public static void printFrequencyOfNonSorted(int[] input, int n) {
		// arr was in 1 to n ranhge now in 0 to n-1
		for (int i = 0; i < input.length; i++)
			input[i] = input[i] - 1;
		for (int i = 0; i < input.length; i++)
			input[input[i] % n] = input[input[i] % n] + n;

		for (int i = 0; i < input.length; i++)
			System.out.println(i+1 + " "+ input[i] / n);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 2, 3, 3, 5, 5, 8, 8, 8, 9, 9, 10 };
		//printFrequency(arr);
		int arr1[] = { 2, 3, 3, 2, 5 };
		printFrequencyOfNonSorted(arr1, arr1.length);
	}

}
