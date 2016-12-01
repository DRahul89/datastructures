package main.java.array;

/**
 * algo is if in sorted array arr[i to j] is not strictly increasing then arr[ i
 * to j+1] cant be
 * 
 * @author rdixi7
 *
 */
public class StrictlyIncreasingSubarrayCount {

	public static int getStrictlyIncreasingCount(int[] input) {
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[j] > input[j - 1])
					count++;
				else
					break;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 2, 4};
		System.out.println(getStrictlyIncreasingCount(arr));
	}

}
