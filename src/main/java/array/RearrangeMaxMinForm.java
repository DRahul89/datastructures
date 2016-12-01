package main.java.array;

/**
 * in place algo to put array in max min second max second min format array is
 * sorted
 * 
 * @author rdixi7
 *
 */
public class RearrangeMaxMinForm {

	public static void rearrangeInput(int[] input) {
		int n = input.length;
		for (int i = 0; i < n; i++) {
			int temp = input[i];
			while (temp > 0) {
				int j = (i < (n / 2)) ? (2 * i + 1) : 2 * (n - 1 - i);
				if (i == j) {
					input[i] = -temp;
					break;
				}
				int temp2 = temp;
				temp = input[j];
				input[j] = temp2;
				input[j] = -input[j];
				i = j;
			}
		}
		
		for (int i = 0; i < n; i++) {
			input[i]=-input[i];
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		rearrangeInput(arr);
	}
}
