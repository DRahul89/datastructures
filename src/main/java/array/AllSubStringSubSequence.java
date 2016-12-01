package main.java.array;

public class AllSubStringSubSequence {

	/**
	 * for any array of length n there could be max n*(n+1)/2 subarrays
	 * 
	 * @param input
	 */
	public static void printAllSubArrays(int[] input) {

		for (int i = 0; i < input.length; i++) {
			for (int j = i; j < input.length; j++) {

				for (int k = i; k < j; k++)
					System.out.print(input[k] + " ");

				System.out.println();

			}

		}

	}

	/**
	 * for any array of length n there could be pow(2,n)-1 subsequences
	 * 
	 * @param input
	 */
	public static void printAllSubSequences(int[] input) {
		int pow = (int) Math.pow(2, input.length);
		for (int i = 0; i < pow; i++) {
			for (int j = 0; j < input.length; j++) {
				if ((i & (1 << j)) != 0)
					System.out.print(input[j] + " ");

			}
			System.out.println();

		}

	}
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4};
		printAllSubArrays(arr);
		System.out.println("subsequence --------------------");
		printAllSubSequences(arr);
	}

}
