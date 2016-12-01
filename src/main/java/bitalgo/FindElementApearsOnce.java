package main.java.bitalgo;

/**
 * 
 * An array contain element all 3 except one which is only once find that
 * element 
 * 
 * algo is sum bits of all position and take modulo 3 for all appears 3
 * times sum became 0 for one appears one time sum become non zero
 *
 */
public class FindElementApearsOnce {

	public static int printAppearedOnce(int[] input) {
		int one = 1;
		int result = 0;
		int sum = 0;
		for (int index = 0; index < 32; index++) {
			one = 1 << index;
			sum = 0;
			for (int j = 0; j < input.length; j++) {
				if ((input[j] & one) != 0) {
					sum++;
				}
			}
			if (sum % 3 != 0)
				result = result | one;

		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 3, 1, 3 };
		// int arr[] = { 12, 1, 12, 3, 12, 1, 1, 2, 3, 3 };
		System.out.println(printAppearedOnce(arr));
	}
}
