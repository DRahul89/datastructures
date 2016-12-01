package main.java.array;

/**
 * algo is
 * 
 * rotate(arr[], d, n) reverse(arr[], 1, d) ; reverse(arr[], d + 1, n);
 * reverse(arr[], l, n);
 * 
 * Input: arr[] = [1, 2, 3, 4, 5, 6, 7] d = 2 Output: arr[] = [3, 4, 5, 6, 7, 1,
 * 2]
 * 
 * @author rdixi7
 *
 */
public class ArrayRotationAlgorithms {

	public static void rotateArray(int[] input, int d) {
		reverse(input, 0, d - 1);
		reverse(input, d, input.length - 1);
		reverse(input, 0, input.length - 1);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

	private static void reverse(int[] input, int i, int j) {
		while (i < j) {
			int temp = input[i];
			input[i] = input[j];
			input[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		rotateArray(arr, 2);
	}

}
