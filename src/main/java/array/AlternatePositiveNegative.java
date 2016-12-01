package main.java.array;

/**
 * algo is shift all negative numbers to right and then maintain the array as
 * given format
 * 
 * @author rdixi7
 *
 */
public class AlternatePositiveNegative {

	public static void convertToAlternatePositiveNegative(int[] input) {
		int left = 0;
		int right = input.length - 1;
		// shift all negative to right
		while (left < right) {
			while (input[++left] > 0)
				;
			while (input[--right] < 0)
				;
			if (left < right) {
				int temp = input[left];
				input[left] = input[right];
				input[right] = temp;
			}
		}
		if (left == 0 || left == input.length)
			return;
		int k = 0;
		while (k < input.length && left < input.length) {
			int temp = input[left];
			input[left] = input[k];
			input[k] = temp;
			k = k + 2;
			left = left + 1;
		}

		for (int i = 0; i < input.length; i++)
			System.out.print(input[i] + " ");
	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, -4, -1, 6, -9 };
		convertToAlternatePositiveNegative(arr);
	}

}