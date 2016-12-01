package main.java.array;

/**
 * a[i] > a[j] > a[k]
 * 
 * i< j < k inversion of array
 */
public class InversionCount {
	/**
	 * compute all smaller on right and all greater on left for all element and
	 * multiply by permutation
	 * 
	 * @param input
	 * @return
	 */
	public static int totalInversionCount(int[] input) {
		int totalInvCount = 0;
		for (int i = 0; i < input.length; i++) {
			int smaller = 0;
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] > input[j])
					smaller++;
			}

			int greater = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (input[i] < input[j])
					greater++;
			}
			totalInvCount = totalInvCount + (smaller * greater);
		}
		return totalInvCount;
	}

	public static void main(String[] args) {
		int arr[] = { 8, 4, 2, 1 };
		System.out.println(totalInversionCount(arr));
	}

}
