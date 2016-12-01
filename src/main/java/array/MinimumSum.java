package main.java.array;

import java.util.Arrays;

/**
 * algo is min number can be formed from a sorted array is smallest then econd
 * smallest and so on
 * 
 * @author rdixi7
 *
 */
public class MinimumSum {

	public static int getMinimumSum(int[] input) {
		int first = 0;
		int second = 0;
		Arrays.sort(input);
		for (int i = 0; i < input.length; i++) {
			if ((i & 1) != 0) {
				first = first * 10 + input[i];
			} else {
				second = second * 10 + input[i];
			}

		}
		System.out.println("first no " + first);
		System.out.println("second no " + second);

		return first + second;
	}
	
	public static void main(String[] args) {
		int arr[] = {6, 8, 4, 5, 2, 3};
		System.out.println(getMinimumSum(arr));
	}

}
