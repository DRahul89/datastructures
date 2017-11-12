package main.java.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * for {1, 9, 3, 10, 4, 20, 2} answer will be 4 as 1,3,4,2 elements of
 * subsequence and consecutive note these are sub sequence elements not sub
 * arrays
 * 
 * @author rdixi3
 *
 */
public class LargestConsecutiveSubsequence {

	public static int printLargestConsecutiveSubsequence(int[] arr) {
		Set<Integer> unique = new HashSet<>();
		int maxResult = -1;
		for (int i = 0; i < arr.length; i++) {
			unique.add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			// means no smaller than that exist so this could be a starting
			// point
			if (!unique.contains(arr[i] - 1)) {
				int j = arr[i];
				while (unique.contains(j))
					j++;
				if ((j - arr[i]) > maxResult) {
					maxResult = j - arr[i];
				}
			}
		}
		return maxResult;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
		System.out.println(printLargestConsecutiveSubsequence(arr));
	}
}
